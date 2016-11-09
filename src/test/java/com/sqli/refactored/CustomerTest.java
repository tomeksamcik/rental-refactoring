package com.sqli.refactored;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

public class CustomerTest {

	final static Logger logger = Logger.getLogger(CustomerTest.class);

	private Customer customer;

	@Before
	public void setUp() throws Exception {
		customer = new Customer("Test Customer");

		Movie childrenMovie = new Fable("Shrek");
		Movie regularMovie = new Regular("Titanic");
		Movie newReleaseMovie = new NewRelease("James Bourne");

		Rental rental1 = childrenMovie.rent(1);
		Rental rental2 = regularMovie.rent(2);
		Rental rental3 = newReleaseMovie.rent(3);

		customer.addRental(rental1);
		customer.addRental(rental2);
		customer.addRental(rental3);
	}

	@Test
	public void test() {
		String statement = customer.statement();
		logger.info(statement);
		assertTrue(customer.getTotalPrice() == 12.5);
	}

}
