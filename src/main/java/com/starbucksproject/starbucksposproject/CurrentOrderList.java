package com.starbucksproject.starbucksposproject;

import java.util.ArrayList;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.HexFormat;
import javafx.scene.input.KeyEvent;

//Use this class as a shared list between controllers. Load and save to it when swapping
public class CurrentOrderList {
	Connection conn = null;
	private static CurrentOrderList instance;
	private ArrayList<String> currentOrder;

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

	public void resetOrder(){
		currentOrder.clear();
	}

	public void completeTransaction() {
		//
	}
}
