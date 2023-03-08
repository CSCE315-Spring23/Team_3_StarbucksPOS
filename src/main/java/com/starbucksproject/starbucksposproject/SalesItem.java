package com.starbucksproject.starbucksposproject;

public class SalesItem {
	private int day;
	private int date;
	private int week;
	private int year;
	private boolean game_day;
	private double sales;

	public SalesItem(int day, int date, int week, int year, boolean game_day, double sales) {
		this.day = day;
		this.date = date;
		this.week = week;
		this.year = year;
		this.game_day = game_day;
		this.sales = sales;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public int getWeek() {
		return week;
	}

	public void setWeek(int week) {
		this.week = week;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public boolean isGame_day() {
		return game_day;
	}

	public void setGame_day(boolean game_day) {
		this.game_day = game_day;
	}

	public double getSales() {
		return sales;
	}

	public void setSales(double sales) {
		this.sales = sales;
	}
}


