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
	
	private Set<String> randomStringSet = new HashSet<>();
	
	public List<Profile> createProfiles(int size) {
		List<CreditCard> creditCards = creditCardDao.getAll();
		List<Name> names = GhostJsonUtils.getRandomNames(size);
		return createProfiles(creditCards, names, size);
	}
	
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
				// parallel arrays, one name for each profile
				Name currentName = names.get(index);
				Profile profile = buildWithProfileData(creditCards.get(i), currentName, index);
				
		    	profiles.add(profile);
		    	profilesCreated++;
		    	index++;
			}
			
			
		}
		return profiles;
	}
	
	private Profile buildWithProfileData(CreditCard card, Name name, int index) {
		Profile profile = new Profile();
		Customer cust = buildCustomer(name);
		profile.setCreditCard(card);
		profile.setCustomer(cust);
		profile.setStatus(STATUS);
		profile.setName(PROFILE + (index + 1));
		return profile;
	}
	
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
