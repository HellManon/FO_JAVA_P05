package com.safetynetalerts.model;

public class Person {

	private String firsNname;
	private String lastName;
	private String adress;
	private String city;
	private String zip;
	private String phone;
	private String email;
	
	
	
	
	public String getFirsNname() {
		return firsNname;
	}
	public void setFirsNname(String firsNname) {
		this.firsNname = firsNname;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Person(String firstname, String lastname, String address, String city, String zip, String phone, String email) {
		this.firsNname = firstname;
		this.lastName = lastname;
		this.adress = address;
		this.city = city;
		this.zip = zip;
		this.phone = phone;
		this.email = email;
	}
	
	public Person() {
		
	}
}
