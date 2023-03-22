package com.starbucksproject.starbucksposproject;

public class ZReportItem {
	private int date;
	private double sales;

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public double getSales() {
		return sales;
	}

	public void setSales(double sales) {
		this.sales = sales;
	}

	public ZReportItem(int date, double sales) {
		this.date = date;
		this.sales = sales;
	}
}

