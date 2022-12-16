package com.safetynetalerts.model;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class FireStation {

	private Set<String> addresses = new HashSet<>();
	private String address;
	private String station;
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStation() {
		return station;
	}
	public void setStation(String station) {
		this.station = station;
	}
	
	public FireStation(String station) {
		this.station = station;
	}

	public FireStation() {
		
	}

	public FireStation addAddress(String address) {
        addresses.add(address);
        return this;
    }

    public Set<String> getAddresses() {
        return addresses.stream().collect(Collectors.toSet());
    }
}	
