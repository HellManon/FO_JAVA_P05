package com.safetynetalerts.service;

import java.util.Map;

import com.safetynetalerts.model.FireStation;

public interface IFireStationService {
	Map<String, FireStation> getFireStation();

    Result deleteAddressOfFireStation(String address);

    Result deleteFireStation(String station);

    FireStation saveFireStation(FireStation fireStation);

    Result updateFireStationOfAddress(FireStation fireStation, String station, String address);

}
