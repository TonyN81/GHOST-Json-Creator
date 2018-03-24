package com.ghostjsonconverter.dao.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.ghostjsonconverter.constants.ProfileField;
import com.ghostjsonconverter.dao.ProfileDao;
import com.ghostjsonconverter.model.Profile;

public class ProfileJsonDaoImpl implements ProfileDao {
	
	private static String PROFILE_OUTPUT_PATH = "profiles.json";
	
	private static JsonFactory jfactory = new JsonFactory();
	
	public int save(List<Profile> profiles) {
		JsonGenerator jGenerator = null;
		try {
			jGenerator = jfactory.createGenerator(new File(PROFILE_OUTPUT_PATH), JsonEncoding.UTF8);
			jGenerator.writeStartArray();
			// write the profile to json file
			for (Profile profile : profiles) {
				
		    	jGenerator.writeStartObject(); // {
		    	
		    	jGenerator.writeStringField(ProfileField.ADDRESS.getField(), profile.getCustomer().getFullAddress());
		    	jGenerator.writeStringField(ProfileField.APT.getField(), profile.getCustomer().getApt());
		    	jGenerator.writeStringField(ProfileField.CARD_NUMBER.getField(), profile.getCreditCard().getCardNumber());
		    	jGenerator.writeStringField(ProfileField.CARD_TYPE.getField(), profile.getCreditCard().getCardType());
		    	jGenerator.writeStringField(ProfileField.CITY.getField(), profile.getCustomer().getCity());
		    	jGenerator.writeStringField(ProfileField.COUNTRY.getField(), profile.getCustomer().getCountry());
		    	jGenerator.writeStringField(ProfileField.CVV.getField(), profile.getCreditCard().getCvv());
		    	jGenerator.writeStringField(ProfileField.EXPIRY_MONTH.getField(), profile.getCreditCard().getExpiryMonth());
		    	jGenerator.writeStringField(ProfileField.EXPIRY_YEAR.getField(), profile.getCreditCard().getExpiryYear());
		    	jGenerator.writeStringField(ProfileField.FIRST_NAME.getField(), profile.getCustomer().getFirstName());
		    	jGenerator.writeStringField(ProfileField.LAST_NAME.getField(), profile.getCustomer().getLastName());
		    	jGenerator.writeStringField(ProfileField.PHONE.getField(), profile.getCustomer().getPhone());
		    	jGenerator.writeStringField(ProfileField.STATE.getField(), profile.getCustomer().getState());
		    	jGenerator.writeStringField(ProfileField.ZIP.getField(), profile.getCustomer().getZip());
		    	jGenerator.writeStringField(ProfileField.STATUS.getField(), profile.getStatus());
		    	jGenerator.writeStringField(ProfileField.NAME.getField(), profile.getName());
		
		    	jGenerator.writeEndObject(); // }
			}
			jGenerator.writeEndArray();
			jGenerator.close();
		} catch (IOException e) {
			System.err.println("Error with writing JSON file at " + PROFILE_OUTPUT_PATH);
			return -1;
		}
		return 1;
	}
}
