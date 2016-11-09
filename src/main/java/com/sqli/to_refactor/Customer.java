package com.sqli.to_refactor;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class Customer extends DomainObject {
	public Customer(String name) {
		this.name = name;
	}

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Enumeration r = java.util.Collections.enumeration(rentals);

		String result = "Rental Record for " + name() + "\n";
		while (r.hasMoreElements()) {
			double thisAmount = 0;
			Rental each = (Rental) r.nextElement();

			// determine amounts for each line
			switch (each.tape().movie().priceCode()) {
			case Movie.REGULAR:
				thisAmount += 2;
				if (each.daysRented() > 2)
					thisAmount += (each.daysRented() - 2) * 1.5;
				break;
			case Movie.NEW_RELEASE:
				thisAmount += each.daysRented() * 3;
				break;
			case Movie.CHILDREN:
				thisAmount += 1.5;
				if (each.daysRented() > 3)
					thisAmount += (each.daysRented() - 3) * 1.5;
				break;

			}
			totalAmount += thisAmount;

			// add frequent renter points
			frequentRenterPoints++;
			// add bonus for a two day new release rental
			if ((each.tape().movie().priceCode() == Movie.NEW_RELEASE)
					&& each.daysRented() > 1)
				frequentRenterPoints++;

			// show figures for this rental
			result += "\t" + each.tape().movie().name() + "\t"
					+ String.valueOf(thisAmount) + "\n";

		}
		// add footer lines
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints)
				+ " frequent renter points";
		return result;

	}

	public void addRental(Rental arg) {
		rentals.add(arg);
	}

	private List rentals = new ArrayList();
}
