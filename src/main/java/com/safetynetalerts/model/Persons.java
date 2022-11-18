package model;

import java.util.List;

public class Persons {

	private String firsNname;
	private String lastName;
	private String adress;
	private String city;
	private int zip;
	private String phone;
	private String email;
	private String birthdate;
	private List medication;
	
	
	
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
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
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

	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public List getMedication() {
		return medication;
	}
	public void setMedication(List medication) {
		this.medication = medication;
	}
}
