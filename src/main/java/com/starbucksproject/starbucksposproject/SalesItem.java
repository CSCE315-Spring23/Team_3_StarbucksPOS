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

	private int getDay() {
		return day;
	}

	private void setDay(int day) {
		this.day = day;
	}

	private int getDate() {
		return date;
	}

	private void setDate(int date) {
		this.date = date;
	}

	private int getWeek() {
		return week;
	}

	private void setWeek(int week) {
		this.week = week;
	}

	private int getYear() {
		return year;
	}

	private void setYear(int year) {
		this.year = year;
	}

	private boolean isGame_day() {
		return game_day;
	}

	private void setGame_day(boolean game_day) {
		this.game_day = game_day;
	}

	private double getSales() {
		return sales;
	}

	private void setSales(double sales) {
		this.sales = sales;
	}
}


