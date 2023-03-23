package com.starbucksproject.starbucksposproject;

public class ZReportItem {
	private int last_transaction_id;
	private int last_transaction_date;
	private double total;

	public int getLast_transaction_id() {
		return last_transaction_id;
	}

	public void setLast_transaction_id(int last_transaction_id) {
		this.last_transaction_id = last_transaction_id;
	}

	public int getLast_transaction_date() {
		return last_transaction_date;
	}

	public void setLast_transaction_date(int last_transaction_date) {
		this.last_transaction_date = last_transaction_date;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public ZReportItem(int last_transaction_id, int last_transaction_date, double total) {
		this.last_transaction_id = last_transaction_id;
		this.last_transaction_date = last_transaction_date;
		this.total = total;
	}
}

