package com.starbucksproject.starbucksposproject;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

//Use this class as a shared list between controllers. Load and save to it when swapping


/**
 * Static class that holds the current order list for quick loading and saving when swapping menus.
 */
public class CurrentOrderList {
	private static CurrentOrderList instance;
	private ArrayList<String> currentOrder;

	private String CurrentEmployee = "";
	private boolean isManager = false;

	private float TotalPrice = 0.0F;
	private HashMap<Integer, String> idToName = null;
	private Connection conn = null;


	/**
	 * This function creates a array list for the current order
	 */
	private CurrentOrderList(){
		currentOrder = new ArrayList<String>();
		conn = DBConnection.getInstance().getConnection();
	}
	//Menu item button click -> Add menu item to array list


	/**
	 * Executes the query in the  and grabs the first entry of the column provided.
	 * @param query Full SQL query to be requested
	 * @param columnName The column to be grabbed by the query
	 * @return Returns the first String from the query provided or a blank string if not found
	 * @see Statement
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
		}
		return returnString;
	}

	/**
	 * Executes the query in parameter name and grabs the first entry of the column provided.
	 * @param query Full SQL query to be processed
	 */
	private void processQuery(String query) {
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
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
		if (!latestDate.equals(dateString)) {
			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT quantity FROM inventory ORDER BY inventory_id");
				ArrayList<Double> doubleArrayList = new ArrayList<>();
				while (rs.next()){
					doubleArrayList.add(rs.getDouble("quantity"));
				}
//				Array array = rs.getArray("quantity");
				Array array = conn.createArrayOf("double", doubleArrayList.toArray());
				PreparedStatement prepped = conn.prepareStatement("INSERT INTO inventory_history (date, ingredient_amounts) VALUES (?, ?)");
				prepped.setInt(1, Integer.parseInt(dateString));
				prepped.setArray(2, array);
				prepped.executeUpdate();
			}
			catch (SQLException e){
				e.printStackTrace();
			}
		}
		else{
			try{
				PreparedStatement prepped = conn.prepareStatement("UPDATE inventory_history SET ingredient_amounts[?]=? WHERE date=?");
				prepped.setInt(1, index);
				prepped.setDouble(2, amt);
				prepped.setInt(3, Integer.parseInt(dateString));
				prepped.executeUpdate();
			}
			catch (SQLException e){
				e.printStackTrace();
			}
		}

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
				if (!CheckIngredientInventory(ingredientsList[i], Double.parseDouble(amountsList[i]))) {
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
		String query;
		if(id/1000 == 999) {
			query = "SELECT " + columnName + " FROM special_menu_items WHERE item_id = " + id;
		}
		else{
			query = "SELECT " + columnName + " FROM menu_items WHERE item_id = " + id;
		}
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
				int id = Integer.parseInt(order);
				String[] ingredientsList = GetList("ingredients", id);
				String[] amountsList = GetList("amounts", id);
				System.out.println("ingredients list: " + Arrays.toString(ingredientsList));
//				System.out.println("Amounts list: " + Arrays.toString(amountsList));
//				UpdateDBForInventory(ingredientsList, amountsList);
				for (int i = 0; i < ingredientsList.length; i++) {
					Statement stmt = conn.createStatement();
					stmt.executeUpdate("UPDATE inventory SET quantity=quantity - " + amountsList[i] + " WHERE inventory_name='" + ingredientsList[i] + "'");
					stmt.close();
					stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery("SELECT quantity,inventory_id FROM inventory WHERE inventory_name='" + ingredientsList[i] + "'");
					rs.next();
					double amt = rs.getDouble("quantity");
					int inventoryId = rs.getInt("inventory_id");
					updateInventoryHistory(inventoryId-1000, amt);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
//			System.exit(0);
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
	 * The function returns the CurrentOrderList as a string array.
	 * @return Returns an ArrayList of Strings containing the current order, will not be null due to instantiation through getInstance
	 */
	public ArrayList<String> getCurrentOrder(){
		return currentOrder;
	}

	/**
	 * The function returns the CurrentEmployee as a string.
	 * @return CurrentEmployee Returns current employee ID
	 *
	 */
	public String getCurrentEmployee() {
		return CurrentEmployee;
	}

	/**
	 *
	 * The function takes in an employee ID, translates it to the employee name,
	 * and then stores the employee name within the code.
	 * @param employeeID Employee ID given by login system
	 *
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
	 * @param currentEmployee Name of the current employee
	 *
	 * The function sets the CurrentEmployee object within the class to the parameter value currentEmployee.
	 */
	public void setCurrentEmployee(String currentEmployee){
		this.CurrentEmployee = currentEmployee;
	}
	public void setCurrentOrder(ArrayList<String> currentOrder){
		this.currentOrder = currentOrder;
	}
	public void resetOrder(){
		currentOrder.clear();
	}

	/**
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
	 * @return A boolean of whether the current employee is a manager or not.
	 */
	public boolean isManager() {
		return isManager;
	}

	/**
	 * The function sets the manager status of CurrentEmployee.
	 */
	public void setManager(boolean manager) {
		isManager = manager;
	}

	/**
	 *
	 * @return Returns HashMap containing pairs between menu item ids and menu item names (not display names since they don't distinguish sizes)
	 * @throws SQLException
	 */
	public HashMap<Integer, String> getIdToNameMap() throws SQLException{
		if (idToName == null){
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT item_id,item_name FROM menu_items");
			idToName = new HashMap<>();
//			HashMap<String, Integer> nameToId = new HashMap<>();
			while (rs.next()){
				idToName.put(rs.getInt("item_id"), rs.getString("item_name"));
				//can also do opposite
			}
			rs.close();
			stmt.close();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT item_id,inventory_name FROM special_menu_items");
			while (rs.next()){
				idToName.put(rs.getInt("item_id"), rs.getString("inventory_name"));
				//can also do opposite
			}
		}
		return idToName;
	}
}
