package com.starbucksproject.starbucksposproject;

import java.sql.*;
import java.util.ArrayList;

public class NewItem {
	private Connection conn = DBConnection.getInstance().getConnection();

	private int itemID;
	private String item_name;
	private String display_name;
	private String category;
	private boolean sized;
	private ArrayList<String> ingredients;
	private ArrayList<String> amounts;
	private float price;

	private String[] sizes = new String[]{"tall", "grande", "venti"};

	public void createNewItem(String item_name, String display_name, String category, boolean sized, ArrayList<String> ingredients, ArrayList<String> amounts, float price) {
		this.item_name = item_name;
		this.display_name = display_name;
		this.category = category;
		this.sized = sized;
		this.ingredients = ingredients;
		this.amounts = amounts;
		this.price = price;
	}

	public void processNewItem() {
		// Check if Display Name exist:
		checkDisplayName();
		// Create the ID and return it as "itemID"
		this.itemID = createNewID();
		String query;
		// if sized, run the sizedAdding, else nonSizedAdding
		if (this.sized) {
			for (String size : sizes) {
				query = createQuery(size);
				processQuery(query);
			}
		} else {
			query = createQuery("NA");
			processQuery(query);
		}
	}

	private void checkDisplayName() {

	}

	private int createNewID() {
		// Check if the category exist
		String lastIdQuery = "SELECT MAX(item_id) FROM menu_items WHERE category=" + '\'' + this.category + '\'';

		int itemID = 0;

		String biggestIdQuery = "SELECT MAX (item_id) FROM menu_items";

		try {
			Statement stmt = conn.createStatement();
			ResultSet resSet = stmt.executeQuery(lastIdQuery);
			if (resSet.next()) {
				itemID += 1;
			} else {
				itemID = resSet.getInt("item_id");
				resSet = stmt.executeQuery(biggestIdQuery);
				itemID = resSet.getInt("item_id");
				itemID += 101001;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

		return itemID;
	}

	private String createQuery(String size) {
		String insert = "INSERT INTO menu_items";
		String values = "VALUES (item_id, item_name, display_name, category, size, price)";
		String price = getPriceStr(size);
		String


	}

	private String getPriceStr(String size) {
		float mul = 1;
		if (size == "grande") {
			mul = (float) (this.price * 1.25);
		} else if (size == "venti") {
			mul = (float) (this.price * 1.5);
		}
		return Float.toString(mul);
	}

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
}
