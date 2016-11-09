package com.sqli.refactored;

public abstract class Movie {

	private String name;

	public Movie(String name) {
		this.name = name;
	}

	public Rental rent(Integer daysRented) {
		return new Rental(this, daysRented);
	}

	protected abstract Double calculatePrice(Integer daysRented);

	protected abstract Integer calculateFrequentRenterPoints(
			Integer daysRented, Integer frequentRenterPoints);

	@Override
	public String toString() {
		return name;
	}

}
