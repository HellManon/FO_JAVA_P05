package com.safetynet.alert.service.endpoints;

import com.safetynet.alert.dto.StationAndAddress;

import java.util.List;

public interface IFloodService {
	 List<StationAndAddress> getFlood (List<String> stations);

}
