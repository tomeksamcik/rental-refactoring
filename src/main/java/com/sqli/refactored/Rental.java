package com.sqli.refactored;

public class Rental {

	protected Movie movie;

	protected Integer daysRented;

	public Rental(Movie movie, Integer daysRented) {
		this.movie = movie;
		this.daysRented = daysRented;
	}

	public String getMovieName() {
		return movie.toString();
	}

	public Double calculatePrice() {
		return movie.calculatePrice(daysRented);
	}

	public Integer addBonusRenterPoints(Integer frequentRenterPoints) {
		frequentRenterPoints += movie.calculateFrequentRenterPoints(daysRented,
				frequentRenterPoints);
		return frequentRenterPoints;
	}

}
