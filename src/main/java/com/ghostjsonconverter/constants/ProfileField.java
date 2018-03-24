package com.ghostjsonconverter.constants;

public enum ProfileField {
	
	ADDRESS("address"),
	APT("apt"),
	CARD_NUMBER("cardNumber"),
	CARD_TYPE("cardType"),
	CITY("city"),
	COUNTRY("country"),
	CVV("cvv"),
	EXPIRY_MONTH("expiryMonth"),
	EXPIRY_YEAR("expiryYear"),
	FIRST_NAME("firstName"),
	LAST_NAME("lastName"),
	PHONE("phone"),
	STATE("state"),
	ZIP("zip"),
	STATUS("status"),
	NAME("Name");
	
	private String field;
	
	private ProfileField(String field) {
		this.field = field;
	}
	
	public String getField() {
		return this.field;
	}
}
