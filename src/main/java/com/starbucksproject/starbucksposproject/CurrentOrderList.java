package com.starbucksproject.starbucksposproject;

import java.util.ArrayList;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.HexFormat;
import javafx.scene.input.KeyEvent;

import java.text.SimpleDateFormat;
import java.util.Date;

import java.time.LocalDate;

//Use this class as a shared list between controllers. Load and save to it when swapping
public class CurrentOrderList {
	private static CurrentOrderList instance;
	private ArrayList<String> currentOrder;

	private String CurrentEmployee = "";

	private float TotalPrice = 0.0F;

	private CurrentOrderList(){
		currentOrder = new ArrayList<String>();
	}

	public static CurrentOrderList getInstance(){
		if (instance == null){
			instance = new CurrentOrderList();
		}
		return instance;
	}

	public ArrayList<String> getCurrentOrder(){
		return currentOrder;
	}

	public String getCurrentEmployee() {
		return CurrentEmployee;
	}

	public void setCurrentEmployee(int employeeID) {
		Connection currConn = DBConnection.getInstance().getConnection();
		try {
			Statement stmt = currConn.createStatement();
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

	public void resetOrder(){
		currentOrder.clear();
	}

	public void completeTransaction() {
		Connection currConn = DBConnection.getInstance().getConnection();
		try {
			// get current time
			Statement stmt = currConn.createStatement();
			SimpleDateFormat formatter = new SimpleDateFormat("yyMMdd");
			Date date = new Date();
			String currDate = formatter.format(date);

			// get latest transaction date
			String getLatestTrans = "SELECT MAX(transaction_id) FROM transactions";
			ResultSet result = stmt.executeQuery(getLatestTrans);
			result.next();
			String latestDate = result.getString("transaction_date");

			// if latest transaction date == current date
			String transDate = "";
			if (latestDate == currDate) {
				// transaction: starts at date + 001
				transDate = currDate + "001";
			} else {
				// else,
				// latest transaction_id + 1
				transDate = Integer.toString(Integer.parseInt(latestDate) + 1);
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
			String submitTrans = "INSERT INTO transactions (transaction_id, transaction_date, num_of_items, order_list, employee, total) VALUES ("
					+ transDate + ','
					+ currDate + ','
					+ listSize + ','
					+ orderStr + ','
					+ CurrentEmployee + ','
					+ priceStr + ")";

			stmt.executeQuery(submitTrans);

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}
}
