package com.ghostjsonconverter.util;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Random;

import org.ajbrown.namemachine.Name;
import org.ajbrown.namemachine.NameGenerator;
import org.apache.commons.lang3.RandomStringUtils;

public class GhostJsonUtils {
	
	
	public static String getRandomPhoneNumber() {
		int num1, num2, num3; //3 numbers in area code
        
        Random generator = new Random();
        
        //Area code number; Will not print 8 or 9
        num1 = generator.nextInt(7) + 1; //add 1 so there is no 0 to begin  
        num2 = generator.nextInt(8); //randomize to 8 becuase 0 counts as a number in the generator
        num3 = generator.nextInt(8);
        
        String areaCode = num1 + num2 + num3 + "";
        return getRandomPhoneNumberWithPrefix(areaCode);
	}
	public static String getRandomPhoneNumberWithPrefix(String set1) {
		if (Integer.parseInt(set1) >= 800) {
			throw new InvalidParameterException("Error: cannot use area code with 8 or 9");
		}
		//int num1, num2, num3; //3 numbers in area code
        int set2, set3; //sequence 2 and 3 of the phone number
        
        Random generator = new Random();
        
        //Area code number; Will not print 8 or 9
        //num1 = generator.nextInt(7) + 1; //add 1 so there is no 0 to begin  
        //num2 = generator.nextInt(8); //randomize to 8 becuase 0 counts as a number in the generator
        //num3 = generator.nextInt(8);
        
        // Sequence two of phone number
        // the plus 100 is so there will always be a 3 digit number
        // randomize to 643 because 0 starts the first placement so if i randomized up to 642 it would only go up yo 641 plus 100
        // and i used 643 so when it adds 100 it will not succeed 742 
        set2 = generator.nextInt(643) + 100;
        
        //Sequence 3 of numebr
        // add 1000 so there will always be 4 numbers
        //8999 so it wont succed 9999 when the 1000 is added
        set3 = generator.nextInt(8999) + 1000;
        String num = set1 + set2 + set3;
        
        return num;
	}
	
	public static List<Name> getRandomNames(int size) {
		NameGenerator generator = new NameGenerator();
        List<Name> names = generator.generateNames(size);
        return names;
	}
	
	public static String getRandomString(int length) {
	    boolean useLetters = true;
	    boolean useNumbers = false;
	    String generatedString = RandomStringUtils.random(length, useLetters, useNumbers).toUpperCase();

	    return generatedString;
	}
	
	
	
	
}
