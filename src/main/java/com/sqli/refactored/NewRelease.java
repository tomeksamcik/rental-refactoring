package com.sqli.refactored;

public class NewRelease extends Movie {

	public NewRelease(String name) {
		super(name);
	}

	@Override
	protected Double calculatePrice(Integer daysRented) {
		return (double) daysRented * 3;
	}

	@Override
	protected Integer calculateFrequentRenterPoints(Integer daysRented,
			Integer frequentRenterPoints) {
		if (daysRented > 1) {
			frequentRenterPoints++;
		}
		return frequentRenterPoints;
	}

}
