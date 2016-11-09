package com.sqli.refactored.visitor;

public class Rental {

	protected Visitable movie;

	protected Integer daysRented;

	private PriceCalculator priceCalculator = new PriceCalculator();

	private FrequentRenterPointsCalculator frequentRenterPointsCalculator = new FrequentRenterPointsCalculator();

	public Rental(Movie movie, Integer daysRented) {
		this.movie = movie;
		this.daysRented = daysRented;
	}

	public String getMovieName() {
		return movie.toString();
	}

	public Double calculatePrice() {
		movie.accept(priceCalculator);
		return priceCalculator.getPrice();
	}

	public Integer addBonusRenterPoints(Integer frequentRenterPoints) {
		frequentRenterPointsCalculator
				.setFrequentRenterPoints(frequentRenterPoints);
		movie.accept(frequentRenterPointsCalculator);
		return frequentRenterPointsCalculator.getFrequentRenterPoints();
	}

	private class PriceCalculator implements Visitor {

		private Double price;

		public void visit(Fable fable) {
			price = 1.5;
			if (daysRented > 3) {
				price += (daysRented - 3) * 1.5;
			}
		}

		public void visit(NewRelease newRelease) {
			price = daysRented * 3.0;
		}

		public void visit(Regular regular) {
			price = 2.0;
			if (daysRented > 2) {
				price += (daysRented - 2) * 1.5;
			}
		}

		public Double getPrice() {
			return price;
		}

	}

	private class FrequentRenterPointsCalculator implements Visitor {

		private Integer frequentRenterPoints;

		public void visit(Fable fable) {
			// Do nothing
		}

		public void visit(NewRelease newRelease) {
			if (daysRented > 1) {
				frequentRenterPoints++;
			}
		}

		public void visit(Regular regular) {
			// Do nothing
		}

		public Integer getFrequentRenterPoints() {
			return frequentRenterPoints;
		}

		public void setFrequentRenterPoints(Integer frequentRenterPoints) {
			this.frequentRenterPoints = frequentRenterPoints;
		}

	}

}
