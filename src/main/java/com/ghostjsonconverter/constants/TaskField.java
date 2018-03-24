package com.ghostjsonconverter.constants;

public enum TaskField {
	
	URL("URL"),
	SIZE("Size"),
	PROXY("Proxy"),
	ACCOUNT("Account"),
	PROFILE("Profile"),
	PRODUCT("Product");
	
	private String field;
	
	private TaskField(String field) {
		this.field = field;
	}
	
	public String getField() {
		return this.field;
	}
}
