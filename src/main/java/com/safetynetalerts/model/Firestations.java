package com.safetynetalerts.model;

import javax.persistence.Entity;

@Entity
public class Firestations {
	
	private String address;
	private int stationNumber;
	
	//getters setters
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getStationNumber() {
		return stationNumber;
	}
	public void setStationNumber(int stationNumber) {
		this.stationNumber = stationNumber;
	}

}	
