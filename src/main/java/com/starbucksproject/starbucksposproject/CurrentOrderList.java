package com.starbucksproject.starbucksposproject;

import java.util.ArrayList;


//Use this class as a shared list between controllers. Load and save to it when swapping
public class CurrentOrderList {
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
}
