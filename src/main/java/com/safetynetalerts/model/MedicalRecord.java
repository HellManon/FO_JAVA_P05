package com.safetynetalerts.model;

public class MedicalRecord {

	private String firstName;
	private String lastName;
	private String birthDate;
	private String medications;
	private String allergies;
	
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
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getMedications() {
		return medications;
	}
	public void setMedications(String medications) {
		this.medications = medications;
	}
	public String getAllergies() {
		return allergies;
	}
	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}
	
	public MedicalRecord(String firstname, String lastname, String birthdate, String medications, String allergies) {
		this.firstName = firstname;
		this.lastName = lastname;
		this.birthDate = birthdate;
		this.medications = medications;
		this.allergies = allergies;
	}
	
	public MedicalRecord () {
		
	}
}
