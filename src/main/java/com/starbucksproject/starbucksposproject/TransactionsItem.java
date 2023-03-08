package com.starbucksproject.starbucksposproject;

import java.sql.Array;

public class TransactionsItem {
	private int transaction_id;
	private int transaction_date;
	private int num_of_items;
	private String order_list;
	private String employee;
	private double total;

	public TransactionsItem(int transaction_id, int transaction_date, int num_of_items, String order_list, String employee, double total) {
		this.transaction_id = transaction_id;
		this.transaction_date = transaction_date;
		this.num_of_items = num_of_items;
		this.order_list = order_list;
		this.employee = employee;
		this.total = total;
	}

	public int getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}

	public int getTransaction_date() {
		return transaction_date;
	}

	public void setTransaction_date(int transaction_date) {
		this.transaction_date = transaction_date;
	}

	public int getNum_of_items() {
		return num_of_items;
	}

	public void setNum_of_items(int num_of_items) {
		this.num_of_items = num_of_items;
	}

	public String getOrder_list() {
		return order_list;
	}

	public void setOrder_list(String order_list) {
		this.order_list = order_list;
	}

	public String getEmployee() {
		return employee;
	}

	public void setEmployee(String employee) {
		this.employee = employee;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
}
