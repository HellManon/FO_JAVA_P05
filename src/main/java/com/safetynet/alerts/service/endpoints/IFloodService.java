package com.safetynet.alerts.service.endpoints;

import java.util.List;

import com.safetynet.alerts.dto.StationAndAddress;

public interface IFloodService {
	 List<StationAndAddress> getFlood (List<String> stations);

}
