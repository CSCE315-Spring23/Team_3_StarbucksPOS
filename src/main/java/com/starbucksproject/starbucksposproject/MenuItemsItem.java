package com.starbucksproject.starbucksposproject;

public class MenuItemsItem {
	private int item_id;
	private String item_name;
	private String display_name;
	private String category;
	private String size;
	private String ingredients;

	private String amounts;
	private double price;
	private boolean enabled;

	public MenuItemsItem(int item_id, String item_name, String display_name, String category, String size, String ingredients, String amounts, double price) {
		this.item_id = item_id;
		this.item_name = item_name;
		this.display_name = display_name;
		this.category = category;
		this.size = size;
		this.ingredients = ingredients;
		this.amounts = amounts;
		this.price = price;
		enabled = true;
	}

	public MenuItemsItem(int item_id, String item_name, String display_name, String category, String size, String ingredients, String amounts, double price, boolean enabled) {
		this.item_id = item_id;
		this.item_name = item_name;
		this.display_name = display_name;
		this.category = category;
		this.size = size;
		this.ingredients = ingredients;
		this.amounts = amounts;
		this.price = price;
		this.enabled = enabled;
	}

	//Used for temp lookup in special menu items
	public MenuItemsItem(String item_name, String display_name, String category, double price, boolean enabled) {
		this.item_id = 0;
		this.item_name = item_name;
		this.display_name = display_name;
		this.category = category;
		this.size = "NA";
		this.ingredients = "";
		this.price = price;
		this.enabled = enabled;
	}

	public String getAmounts() {
		return amounts;
	}

	public void setAmounts(String amounts) {
		this.amounts = amounts;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getDisplay_name() {
		return display_name;
	}

	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public double getPrice(){
		return price;
	}

	public void setPrice(double price){
		this.price = price;
	}
}

