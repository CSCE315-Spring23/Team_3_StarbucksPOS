package com.starbucksproject.starbucksposproject;

public class InventoryItem {
	private int inventory_id;
	private String inventory_name;
	private double quantity;

	private int last_stocked;
	private double costs;

	public InventoryItem(int inventory_id, String inventory_name, double quantity, int last_stocked, double costs) {
		this.inventory_id = inventory_id;
		this.inventory_name = inventory_name;
		this.quantity = quantity;
		this.last_stocked = last_stocked;
		this.costs = costs;
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

	public int getLast_stocked(){
		return last_stocked;
	}

	public void setLast_stocked(int last_stocked){
		this.last_stocked = last_stocked;
	}

	public double getCosts() {
		return costs;
	}

	public void setCosts(double costs) {
		this.costs = costs;
	}
}

