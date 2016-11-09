package com.sqli.refactored;

public class Regular extends Movie {

	public Regular(String name) {
		super(name);
	}

	@Override
	protected Double calculatePrice(Integer daysRented) {
		double price = 2;
		if (daysRented > 2) {
			price += (daysRented - 2) * 1.5;
		}
		return price;
	}

	@Override
	protected Integer calculateFrequentRenterPoints(Integer daysRented,
			Integer frequentRenterPoints) {
		return frequentRenterPoints;
	}

}
