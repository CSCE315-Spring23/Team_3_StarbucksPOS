package com.starbucksproject.starbucksposproject;

import java.sql.Array;

public class TransactionsItem {
	private int transaction_id;
	private int transaction_date;
	private int num_of_items;
	private Array order_list;
	private String employee;
	private double total;

	public TransactionsItem(int transaction_id, int transaction_date, int num_of_items, Array order_list, String employee, double total) {
		this.transaction_id = transaction_id;
		this.transaction_date = transaction_date;
		this.num_of_items = num_of_items;
		this.order_list = order_list;
		this.employee = employee;
		this.total = total;
	}

	private int getTransaction_id() {
		return transaction_id;
	}

	private void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}

	private int getTransaction_date() {
		return transaction_date;
	}

	private void setTransaction_date(int transaction_date) {
		this.transaction_date = transaction_date;
	}

	private int getNum_of_items() {
		return num_of_items;
	}

	private void setNum_of_items(int num_of_items) {
		this.num_of_items = num_of_items;
	}

	private Array getOrder_list() {
		return order_list;
	}

	private void setOrder_list(Array order_list) {
		this.order_list = order_list;
	}

	private String getEmployee() {
		return employee;
	}

	private void setEmployee(String employee) {
		this.employee = employee;
	}

	private double getTotal() {
		return total;
	}

	private void setTotal(double total) {
		this.total = total;
	}
}
