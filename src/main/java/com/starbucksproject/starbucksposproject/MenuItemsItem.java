package com.starbucksproject.starbucksposproject;

public class MenuItemsItem {
	private int item_id;
	private String item_name;
	private String display_name;
	private String category;
	private String size;
	private String ingredients;
	private double price;

	public MenuItemsItem(int item_id, String item_name, String display_name, String category, String size, String ingredients, double price) {
		this.item_id = item_id;
		this.item_name = item_name;
		this.display_name = display_name;
		this.category = category;
		this.size = size;
		this.ingredients = ingredients;
		this.price = price;
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

