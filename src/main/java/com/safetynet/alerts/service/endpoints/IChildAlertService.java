package com.safetynet.alerts.service.endpoints;
import com.safetynet.alerts.dto.ChildrenAndAdults;

import java.util.List;


public interface IChildAlertService {
	List<ChildrenAndAdults> getChildAlert(String address) throws Exception;

}
