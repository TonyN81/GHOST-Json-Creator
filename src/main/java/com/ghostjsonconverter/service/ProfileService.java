package com.ghostjsonconverter.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.ajbrown.namemachine.Name;

import com.ghostjsonconverter.dao.impl.CreditCardApachePoiDaoImpl;
import com.ghostjsonconverter.dao.impl.ProfileJsonDaoImpl;
import com.ghostjsonconverter.model.CreditCard;
import com.ghostjsonconverter.model.Customer;
import com.ghostjsonconverter.model.Profile;
import com.ghostjsonconverter.util.GhostJsonUtils;

public class ProfileService {
	
	private CreditCardApachePoiDaoImpl creditCardDao = new CreditCardApachePoiDaoImpl();
	private ProfileJsonDaoImpl profileDao = new ProfileJsonDaoImpl();
	
	// static data about current profile
	private static String ADDRESS_NUMBER = "5914";
	private static String ADDRESS_STREET_NAME = "Sorrel Ave";
	private static String CITY = "San Jose";
	private static String COUNTRY = "US";
	private static String STATE = "CA";
	private static String ZIP = "95123";
	private static String STATUS = "Idle";
	private static String AREA_CODE = "408";
	private static String PROFILE = "Profile";
	// verify the random string hasnt been used already
	private Set<String> randomStringSet = new HashSet<>();
	
	/**
	 * Creates profiles of a given size, credit cards and names
	 * are fetched inside method to used with helper method.
	 * @param size The amount of profiles to make.
	 * @return List of Profiles.
	 */
	public List<Profile> createProfiles(int size) {
		List<CreditCard> creditCards = creditCardDao.getAll();
		List<Name> names = GhostJsonUtils.getRandomNames(size);
		return createProfiles(creditCards, names, size);
	}
	
	/**
	 * Save profiles to JSON file
	 * @param profiles
	 * @return
	 */
	public boolean saveProfilesToJson(List<Profile> profiles) {
		
		if (profileDao.save(profiles) < 0) {
			System.out.println("Failed to save profiles");
			return false;
		}
		else {
			System.out.println("Successfully saved " + profiles.size() + " profiles.");
			return true;
		}
		
	}
	
	/**
	 * Helper method to create profiles with credit cards, names and amount
	 * @param creditCards List of CreditCard to assign to profile.
	 * @param names List of names to assign to each profile.
	 * @param amount The amount of profiles to create.
	 * @return List of Profiles.
	 */
	private List<Profile> createProfiles(List<CreditCard> creditCards, List<Name> names, int amount) {
		int profilesCreated = 0;
		int index = 0;
		List<Profile> profiles = new ArrayList<>();
		while (profilesCreated < amount) {
			// keep looping through CC's making profiles
			for (int i = 0; i < creditCards.size(); i++) {
				if (profilesCreated >= amount) {
					break;
				}
				// get a unique name for each profile
				Name currentName = names.get(index);
				Profile profile = buildWithProfileData(creditCards.get(i), currentName, index);
				
		    	profiles.add(profile);
		    	profilesCreated++;
		    	index++;
			}
		}
		return profiles;
	}
	
	/**
	 * Creates an individual profile.
	 * @param card CreditCard to assign.
	 * @param name First and last name combo.
	 * @param index Used to give profile a unique name.
	 * @return
	 */
	private Profile buildWithProfileData(CreditCard card, Name name, int index) {
		Profile profile = new Profile();
		Customer cust = buildCustomer(name);
		profile.setCreditCard(card);
		profile.setCustomer(cust);
		profile.setStatus(STATUS);
		profile.setName(PROFILE + (index + 1));
		return profile;
	}
	
	/**
	 * Creates a Customer with random name and part of address.
	 * @param name The name to give to the profile.
	 * @return Customer with random name and part of address.
	 */
	private Customer buildCustomer(Name name) {
		Customer cust = new Customer();
		cust.setAddressNumber(ADDRESS_NUMBER);
		cust.setAddressRandom(getUniqueRandomString());
		cust.setAddressStreetName(ADDRESS_STREET_NAME);
		cust.setApt("");
		cust.setCity(CITY);
		cust.setCountry(COUNTRY);
		cust.setFirstName(name.getFirstName());
		cust.setLastName(name.getLastName());
		cust.setPhone(GhostJsonUtils.getRandomPhoneNumberWithPrefix(AREA_CODE));
		cust.setState(STATE);
		cust.setZip(ZIP);
		return cust;
	}
	
	/**
	 * Uses a HashSet to verify the String hasnt been used already.
	 * @return A unique String verified by HashSet backing.
	 */
	private String getUniqueRandomString() {
		StringBuilder bldr = new StringBuilder();
		
		while (true) {
			bldr.append(GhostJsonUtils.getRandomString(3));
			if (randomStringSet.contains(bldr.toString())) {
				bldr = new StringBuilder();
			}
			else {
				break;
			}
		}
		return bldr.toString();
	}
}
