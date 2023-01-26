package com.safetynet.alerts.service;

import java.util.Map;

import com.safetynet.alerts.model.FireStation;

public interface IFireStationService {
	Map<String, FireStation> getFireStation();

    Result deleteAddressOfFireStation(String address);

    Result deleteFireStation(String station);

    FireStation saveFireStation(FireStation fireStation);

    Result updateFireStationOfAddress(FireStation fireStation, String station, String address);

}
