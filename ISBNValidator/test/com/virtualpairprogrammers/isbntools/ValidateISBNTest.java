package com.virtualpairprogrammers.isbntools;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValidateISBNTest {

	@Test
	public void check_valid_iSBN() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("0140449116");
		assertTrue("first value", result);
		result = validator.checkISBN("0140177396");
		assertTrue("second value", result);
	}
	
	@Test
	public void ISBN_ending_in_X_are_Valid() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("012000030X");
		assertTrue(result);
	}
	
	@Test
	public void ISBN_with_thirteen_numbers_are_also_valid() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("9780441013593");
		assertTrue(result);
	}
	
	@Test
	public void check_an_invalid_ISBN() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("0140449117");
		assertFalse(result);
	}
	
	@Test(expected = NumberFormatException.class)
	public void nine_digit_ISBN_are_not_allowed() {
		ValidateISBN validator = new ValidateISBN();
		validator.checkISBN("123456789");
	}
	
	@Test (expected = NumberFormatException.class)
	public void letters_are_not_allowed() {
		ValidateISBN validator = new ValidateISBN();
		validator.checkISBN("helloworld");
	}
	

}
