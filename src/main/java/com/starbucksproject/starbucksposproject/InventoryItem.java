package com.starbucksproject.starbucksposproject;

public class InventoryItem {
	private int inventory_id;
	private String inventory_name;
	private int quantity;

	private int last_stocked;

	public InventoryItem(int inventory_id, String inventory_name, int quantity, int last_stocked) {
		this.inventory_id = inventory_id;
		this.inventory_name = inventory_name;
		this.quantity = quantity;
		this.last_stocked = last_stocked;
	}

	public int getInventory_id() {
		return inventory_id;
	}

	public void setInventory_id(int inventory_id) {
		this.inventory_id = inventory_id;
	}

	public String getInventory_name() {
		return inventory_name;
	}

	public void setInventory_name(String inventory_name) {
		this.inventory_name = inventory_name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getLast_stocked(){
		return last_stocked;
	}

	public void setLast_stocked(int last_stocked){
		this.last_stocked = last_stocked;
	}
}

