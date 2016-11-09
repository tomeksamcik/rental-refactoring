package com.sqli.refactored;

import java.util.ArrayList;
import java.util.List;

public class Customer {

	private String name;

	private List<Rental> rentals = new ArrayList<Rental>();

	private Integer frequentRenterPoints = 0;

	private Double totalPrice;

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental rental) {
		rentals.add(rental);
	}

	public String statement() {
		StringBuilder result = new StringBuilder();
		result.append("Rental Record for " + name + "\n");

		totalPrice = 0.0;
		for (Rental rental : rentals) {
			totalPrice += rental.calculatePrice();
			frequentRenterPoints = rental.addBonusRenterPoints(frequentRenterPoints);

			result.append("\t" + rental.getMovieName() + "\t" + totalPrice
					+ "\n");
		}
		result.append("Amount owed is " + totalPrice + "\n");
		result.append("You earned " + frequentRenterPoints
				+ " frequent renter points");
		return result.toString();
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

}
