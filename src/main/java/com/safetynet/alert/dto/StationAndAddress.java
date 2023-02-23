package com.safetynet.alert.dto;

import lombok.Data;

import java.util.List;

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