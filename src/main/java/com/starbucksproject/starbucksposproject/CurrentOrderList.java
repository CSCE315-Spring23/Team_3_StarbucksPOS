package com.starbucksproject.starbucksposproject;

import javafx.scene.control.CheckMenuItem;

import java.util.ArrayList;

import java.sql.*;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 *Use this class as a shared list between controllers. Load and save to it when swapping
 */
public class CurrentOrderList {
	private static CurrentOrderList instance;
	private ArrayList<String> currentOrder;

	private String CurrentEmployee = "";
	private boolean isManager = false;

	private float TotalPrice = 0.0F;

	/**
	 * This function creates a array list for the current order
	 */
	private CurrentOrderList(){
		currentOrder = new ArrayList<String>();
	}
	//Menu item button click -> Add menu item to array list

	private Connection conn = DBConnection.getInstance().getConnection();


	/**This function will return a string which is the resultSet of the query
	 * @param query
	 * @param columnName
	 * @return
	 */
	private String requestQuery(String query, String columnName) {
		String returnString = "";
		try {
			Statement stmt = conn.createStatement();
			ResultSet resSet = stmt.executeQuery(query);
			if (resSet.next()) {
				returnString = resSet.getString(columnName);
			} else {
				System.out.println("No results returned in requestQuery.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return returnString;
	}

	/**This function will execute out the SQL query
	 * @param query
	 */
	private void processQuery(String query) {
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}
	/**
	 *
	 * @param ingredients_list
	 * @param ingredients_amt
	 *
	 * Takes all the items in the ingredient lists and subtracts the proper amount of that ingredient from the inventory DB table
	 */
	private boolean UpdateDBForInventory(String[] ingredients_list, String[] ingredients_amt) {
		for (int i=0; i < ingredients_list.length && i < ingredients_amt.length; i++) {
			double amt = Double.parseDouble(ingredients_amt[i]);
			String ingredient = ingredients_list[i];
			try (Statement statement = conn.createStatement()) {
//				PreparedStatement prepped = conn.prepareStatement("SELECT inventory_name,quantity FROM inventory where inventory_name=?");
//				prepped.setString(1, ingredient);
//				ResultSet amountResult = prepped.executeQuery();
//				amountResult.next();
//				double currAmount = amountResult.getDouble("quantity");
//				String currName = amountResult.getString("inventory_name");
//				amountResult.close();
//				prepped.close();
//				if (currAmount < amt){
//					throw new IllegalArgumentException("Ran out of " + currName);
//				}
				System.out.println("Calling the sql to update the DBInventory");
				String sql = "UPDATE inventory SET quantity = quantity - " + amt + " WHERE inventory_name = " + '\'' + ingredient + '\'';
				int index = getIngredientID(ingredient) - 999;
				updateInventoryHistory(index, amt);
				statement.executeUpdate(sql);
			} catch (SQLException e) {
				e.printStackTrace();
				System.err.println(e.getClass().getName() + ": " + e.getMessage());
				System.exit(0);
			}
		}
		return true;
	}

	/**This function will return the primary key of the ingredient item
	 * @param ingredient_name
	 * @return int id
	 */
	private int getIngredientID(String ingredient_name) {
		int id = 0;
		try(Statement statement = conn.createStatement()) {
			String sql = "SELECT inventory_id FROM inventory WHERE inventory_name=" + '\'' + ingredient_name + '\'';
			ResultSet result = statement.executeQuery(sql);
			result.next();
			id = Integer.parseInt(result.getString("inventory_id"));
			result.next();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return id;
	}

	/**This function will update the inventory history date.
	 * @param index
	 * @param amt
	 */
	private void updateInventoryHistory(int index, double amt) {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd");
		String dateString = dateFormat.format(date);
		String getLatestDateQuery = "SELECT MAX(date) FROM inventory_history";
		String latestDate = requestQuery(getLatestDateQuery, "max");
		if (latestDate.equals(dateString) == false) {
			String createNewDateQuery = "INSERT INTO inventory_history (date) VALUES (" + latestDate + ')';
		}

		double currAmt = getAmtFromIndex(latestDate, index);
		double newAmt = currAmt + amt;
		updateAmtAtIndex(latestDate, index, newAmt);
	}

	/**This function returns the amount of an ingredient based off the date and index in the inventory_history array
	 * @param date
	 * @param index
	 * @return float
	 */
	private float getAmtFromIndex(String date, int index) {
		// SELECT my_array[i] FROM my_table WHERE id = row_id;
		//table called inventory_history array called ingredient_amounts column date given by date.
		return Float.parseFloat(requestQuery("SELECT ingredient_amounts["+index+"] FROM inventory_history WHERE date="+date, "ingredient_amounts"));

	}

	/**This function changes the amount of the ingredient in the inventory_history by using date, index, and taking in the amount
	 * @param date
	 * @param index
	 * @param amt
	 */
	private void updateAmtAtIndex(String date, int index, double amt) {
		// UPDATE my_table SET my_array[i] = new_value WHERE id = row_id;
		String query = "UPDATE inventory_history SET ingredient_amounts[" + index + "] = " + amt + " WHERE date=" + date;
		processQuery(query);
	}

	/**This function adds a menu items primary key to the current order if it is in stock
	 * @param menuID
	 */
	public void addItem(String menuID) {
		if (CheckItemAvailability(menuID)) {
			currentOrder.add(menuID);
			System.out.println("Item added to the order list!");
		} else {
			System.out.println("Item currently not available.");
		}
	}

	/**This function will make sure that an item is not out of stock. Returns a boolean whether it is in stock or not
	 * @param order
	 * @return bool
	 */
	private boolean CheckItemAvailability(String order) {
		try {
			String[] ingredientsList = GetList("ingredients", Integer.parseInt(order));
			String[] amountsList = GetList("amounts", Integer.parseInt(order));
			for (int i=0; i < ingredientsList.length && i < amountsList.length; i++) {
				if (CheckIngredientInventory(ingredientsList[i], Double.parseDouble(amountsList[i])) == false) {
					return false;
				}
			}
		} catch (SQLException e) {
			System.out.println("CheckItemAvailability Failed: ingredient for Item does not exist.");
			return false;
		}
		return true;
	}

	/** This function will check the inventory to see if the amount required for an order exceeds the amount in the inventory
	 * @param ingredient
	 * @param amt
	 * @return bool
	 *
	 * @throws SQLException
	 */
	private boolean CheckIngredientInventory(String ingredient, double amt) throws SQLException {
		String sql = "SELECT quantity FROM inventory WHERE inventory_name=" + '\'' + ingredient + '\'';
		try (Statement stat = conn.createStatement()) {
			ResultSet resultSet = stat.executeQuery(sql);
			resultSet.next();
			float currentQuantity = resultSet.getFloat("quantity");
			if (currentQuantity >= amt) {
				return true;
			}
		} catch (SQLException e) {
			throw new SQLException(e);
		}

		return false;
	}

	/**This function will return a list of the ingredients that go into a specific menu item (id to determine the menu item)
	 * @param columnName
	 * @param id
	 * @return string array
	 *
	 * @throws SQLException
	 */
	private String[] GetList(String columnName, int id) throws SQLException {
		String query = "SELECT " + columnName + " FROM menu_items WHERE item_id = " + id;
		try (Statement statement = conn.createStatement()) {
			ResultSet resultSet = statement.executeQuery(query);
			resultSet.next();
			String[] strings = resultSet.getString(columnName).split(",");
			strings[0] = strings[0].replace("{", "");
			strings[strings.length - 1] = strings[strings.length - 1].replace("}", "");
			return strings;
		}
	}


	/**
	 * This function makes sure that the inventory is changed according to what is in the order list
	 */
	private void UpdateInventory() {
		try {
			for (String order : currentOrder) {
				String[] ingredientsList = GetList("ingredients", Integer.parseInt(order));
				String[] amountsList = GetList("amounts", Integer.parseInt(order));
				System.out.println("ingredients list: " + Arrays.toString(ingredientsList));
				System.out.println("Amounts list: " + Arrays.toString(amountsList));
				UpdateDBForInventory(ingredientsList, amountsList);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

		System.out.println("Updated inventory");
	}


	/**This function returns the order list
	 * @return order list
	 */
	public static CurrentOrderList getInstance(){
		if (instance == null){
			instance = new CurrentOrderList();
		}
		return instance;
	}

	/**
	 * @Author: David Liu
	 * @Param: N/A
	 * @return: N/A
	 * @throws: N/A
	 * The function returns the CurrentOrderList as a string array.
	 */
	public ArrayList<String> getCurrentOrder(){
		return currentOrder;
	}

	/**
	 * @Author: David Liu
	 * @Param: N/A
	 * @return: CurrentEmployee
	 * @throws: N/A
	 * The function returns the CurrentEmployee as a string.
	 */
	public String getCurrentEmployee() {
		return CurrentEmployee;
	}

	/**
	 /**
	 * @Author: David Liu
	 * @param employeeID
	 * @return: N/A
	 * @throws: N/A
	 * The function takes in an employee ID, translates it to the employee name,
	 * and then stores the employee name within the code.
	 */
	public void setCurrentEmployee(int employeeID) {
		try {
			Statement stmt = conn.createStatement();
			String sqlQuery = "SELECT * FROM employees WHERE employee_id=" + employeeID;
			ResultSet result = stmt.executeQuery(sqlQuery);
			result.next();

			String employeeName = result.getString("employee_name");
			CurrentEmployee = employeeName;
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}

	/**
	 * @author Devon Kelly
	 * @param currentEmployee
	 * @return N/A
	 *
	 * The function sets the CurrentEmployee object within the class to the parameter value currentEmployee.
	 */
	public void setCurrentEmployee(String currentEmployee){
		this.CurrentEmployee = currentEmployee;
	}
//	public void setCurrentOrder(ArrayList<String> currentOrder){
//		this.currentOrder = currentOrder;
//	}
	public void resetOrder(){
		currentOrder.clear();
	}

	/**
	 * @Author: David Liu
	 * @Param: N/A
	 * @Return: N/A
	 * @Throws: N/A
	 * The function takes all the orders within the CurrentOrder Array, and
	 * updates them to the transaction table listed within the SQL.
	 * Process: Gets the date of the transaction, gets the employee name,
	 * gets the total price of every item, submits the query.
	 */
	public void completeTransaction() {
		if (currentOrder.size() != 0) {
			try {
				// get current time
				Statement stmt = conn.createStatement();
				SimpleDateFormat formatter = new SimpleDateFormat("yyMMdd");
				Date date = new Date();
				String currDate = "1" + formatter.format(date);

				// get latest transaction date
				String getLatestTrans = "SELECT * FROM transactions WHERE transaction_id = (SELECT MAX(transaction_id) FROM transactions)";
				ResultSet result = stmt.executeQuery(getLatestTrans);
				String transDate = "";
				try {
					result.next();
					String latestDate = result.getString("transaction_date");

					// if latest transaction date == current date
					if (!latestDate.equals(currDate)) {
						// transaction: starts at date + 001
						System.out.println(latestDate);
						System.out.println(currDate);
						transDate = currDate + "001";
					} else {
						// else,
						// latest transaction_id + 1
						transDate = Integer.toString(Integer.parseInt(result.getString("transaction_id")) + 1);
					}
				}
				catch (Exception e){
					transDate = "1" + currDate + "001";
				}
				// get the number of items in list
				int listSize = currentOrder.size();

				// for every item in list:
				for (int i=0; i < listSize; i++) {
					// get the price
					String getPrice = "SELECT * FROM menu_items WHERE item_id=" + currentOrder.get(i);
					ResultSet priceResult = stmt.executeQuery(getPrice);
					priceResult.next();
					float itemPrice = Float.parseFloat(priceResult.getString("price"));
					TotalPrice += itemPrice;
				}
				String priceStr = Float.toString(TotalPrice);

				String orderStr = "{";
				for (int i=0; i < listSize; i++) {
					orderStr = orderStr + currentOrder.get(i) + ",";
				}
				orderStr = orderStr.substring(0, orderStr.length()-1);
				orderStr = orderStr + "}";

				// submit the query:
				String submitTrans = "INSERT INTO transactions (transaction_id, transaction_date, num_of_items, order_list, employee, total) VALUES ('"
						+ transDate + "','"
						+ currDate + "',"
						+ listSize + ",'"
						+ orderStr + "','"
						+ CurrentEmployee + "',"
						+ TotalPrice + ")";
				UpdateInventory();
				System.out.println("submitting to db: " + submitTrans);
				stmt.executeUpdate(submitTrans);
				CurrentOrderList.getInstance().resetOrder();




			} catch (Exception e) {
				e.printStackTrace();
				System.err.println(e.getClass().getName() + ": " + e.getMessage());
				System.exit(0);
			}
		} else {
			System.out.println("No Items in OrderList");
		}

	}

	/**
	 * @author: Devon Kelly
	 * @return a boolean of whether the current employee is a manager or not.
	 */
	public boolean isManager() {
		return isManager;
	}

	/**
	 * @author: Devon Kelly
	 * @return N/A
	 * The function sets the manager status of CurrentEmployee.
	 */
	public void setManager(boolean manager) {
		isManager = manager;
	}
}
