package com.starbucksproject.starbucksposproject;

import java.util.ArrayList;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.HexFormat;
import javafx.scene.input.KeyEvent;

import java.time.LocalDate;

//Use this class as a shared list between controllers. Load and save to it when swapping
public class CurrentOrderList {
	private static CurrentOrderList instance;
	private ArrayList<String> currentOrder;

	private String CurrentEmployee;

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

	public void setCurrentEmployee(String employee_name) {
		CurrentEmployee = employee_name;
	}

	public void resetOrder(){
		currentOrder.clear();
	}

	public void completeTransaction() {
		Connection currConn = DBConnection.getInstance().getConnection();
		try {
			Statement stmt = currConn.createStatement();
			String sqlQuery = "";
			ResultSet result = stmt.executeQuery(sqlQuery);
			result.next();

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}
}
