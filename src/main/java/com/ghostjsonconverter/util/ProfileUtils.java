package com.ghostjsonconverter.util;

import com.ghostjsonconverter.model.Customer;
import com.ghostjsonconverter.model.Profile;

public class ProfileUtils {
	
	/* Profile properties */
	
	// customer
	private static String ADDRESS_NUMBER = "5914";
	private static String ADDRESS_STREET_NAME = "Sorrel Ave";
	private static String CARD_TYPE = "Visa";
	private static String CITY = "San Jose";
	private static String COUNTRY = "US";
	private static String STATE = "CA";
	private static String ZIP = "95123";
	private static String STATUS = "Idle";
	private static String AREA_CODE = "650";
	private static String PROFILE = "Profile";
	
	// credit card
	

/*	(String addressNumber, String addressRandom, String addressStreetName, String apt,
			String city, String country, String firstName, String lastName, String phone, String state,
			String zip) {
		*/
	/**
	 * Some properties are random and some are static as defined by requirements.
	 * @return a Customer with static and random data.
	 */
	public static Customer createCustomerWithStaticProperties() {
		String randomChars = GhostJsonUtils.getRandomString(3);
		Customer cust = new Customer(ADDRESS_NUMBER, randomChars, ADDRESS_STREET_NAME, "", CITY,
				COUNTRY, null, null, GhostJsonUtils.getRandomPhoneNumber(), STATE, ZIP);
		return cust;
	}
	
	public static String createStaticProfile() {
		/*
		*/
		Profile profile = new Profile();
		Customer customer = new Customer();
		//customer.setAddressNumber(addressNumber);
		return "";
	}
	
}
