package com.sqli.refactored;

public class Fable extends Movie {

	public Fable(String name) {
		super(name);
	}

	@Override
	protected Double calculatePrice(Integer daysRented) {
		double price = 1.5;
		if (daysRented > 3) {
			price += (daysRented - 3) * 1.5;
		}
		return price;
	}

	@Override
	protected Integer calculateFrequentRenterPoints(Integer daysRented,
			Integer frequentRenterPoints) {
		return frequentRenterPoints;
	}

}
