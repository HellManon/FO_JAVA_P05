package com.safetynet.alert.service;

import com.safetynet.alert.model.FireStation;

import java.util.Map;

public interface IFireStationService {
	Map<String, FireStation> getFireStation();

    Result deleteAddressOfFireStation(String address);

    Result deleteFireStation(String station);

    FireStation saveFireStation(FireStation fireStation);

    Result updateFireStationOfAddress(FireStation fireStation, String station, String address);

}
