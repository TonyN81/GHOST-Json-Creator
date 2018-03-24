package com.ghostjsonconverter.dao;

import java.util.List;

import com.ghostjsonconverter.model.CreditCard;

public interface CreditCardDao {
	
	/**
	 * Gets all of the credit cards.
	 * @return a List of CreditCard objects.
	 */
	List<CreditCard> getAll();
}
