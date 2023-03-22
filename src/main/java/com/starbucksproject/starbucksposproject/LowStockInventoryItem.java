package com.starbucksproject.starbucksposproject;

public class LowStockInventoryItem {
	private int inventory_id;
	private String inventory_name;
	private double quantity;

	private double quantity_required;

	private int last_stocked;

	public LowStockInventoryItem(int inventory_id, String inventory_name, double quantity, double quantity_required, int last_stocked) {
		this.inventory_id = inventory_id;
		this.inventory_name = inventory_name;
		this.quantity = quantity;
		this.quantity_required = quantity_required;
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

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getQuantity_required() { return quantity_required; }

	public void setQuantity_required(double quantity_required) { this.quantity_required = quantity_required; }

	public int getLast_stocked(){
		return last_stocked;
	}

	public void setLast_stocked(int last_stocked){
		this.last_stocked = last_stocked;
	}
}

