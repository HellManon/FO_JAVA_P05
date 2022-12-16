package com.safetynetalerts.dto;

import java.util.List;

import lombok.Data;

@Data
public class StationAndAddress {
    private String station;
    private List<PhoneAndMedicalByAddress> address;

    public StationAndAddress() {

    }

    public StationAndAddress(String station, List<PhoneAndMedicalByAddress> address) {
        this.station = station;
        this.address = address;
    }
}