package com.ghostjsonconverter.model;

public class Customer {
	
	private String addressNumber;
	private String addressRandom;
	private String addressStreetName;
	private String apt;
	private String city;
	private String country;
	private String firstName;
	private String lastName;
	private String phone;
	// 2 digit state value
	private String state;
	private String zip;
	
	public Customer(){}
	public Customer(String addressNumber, String addressRandom, String addressStreetName, String apt,
			String city, String country, String firstName, String lastName, String phone, String state,
			String zip) {
		
		this.addressNumber = addressNumber;
		this.addressRandom = addressRandom;
		this.addressStreetName = addressStreetName;
		this.apt = apt;
		this.city = city;
		this.country = country;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.zip = zip;
	}
	
	public String getAddressNumber() {
		return addressNumber;
	}
	public void setAddressNumber(String addressNumber) {
		this.addressNumber = addressNumber;
	}
	public String getAddressRandom() {
		return addressRandom;
	}
	public void setAddressRandom(String addressRandom) {
		this.addressRandom = addressRandom;
	}
	public String getAddressStreetName() {
		return addressStreetName;
	}
	public void setAddressStreetName(String addressStreetName) {
		this.addressStreetName = addressStreetName;
	}
	
	public String getFullAddress() {
		return this.addressNumber + " " + this.addressRandom + " " + this.addressStreetName;
	}
	public String getApt() {
		return apt;
	}
	public void setApt(String apt) {
		this.apt = apt;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	
}
