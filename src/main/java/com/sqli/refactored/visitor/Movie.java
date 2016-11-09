package com.sqli.refactored.visitor;

public abstract class Movie implements Visitable {

	private String name;

	public Movie(String name) {
		this.name = name;
	}

	public Rental rent(Integer daysRented) {
		return new Rental(this, daysRented);
	}

	@Override
	public String toString() {
		return name;
	}

}
