package com.starbucksproject.starbucksposproject;

public class PairSaleItem {
	String item1;
	String item2;
	int amount;

	public PairSaleItem(String item1, String item2, int amount) {
		this.item1 = item1;
		this.item2 = item2;
		this.amount = amount;
	}

	public String getItem1() {
		return item1;
	}

	public void setItem1(String item1) {
		this.item1 = item1;
	}

	public String getItem2() {
		return item2;
	}

	public void setItem2(String item2) {
		this.item2 = item2;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}
