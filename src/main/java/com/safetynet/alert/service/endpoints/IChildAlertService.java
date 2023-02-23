package com.safetynet.alert.service.endpoints;
import com.safetynet.alert.dto.ChildrenAndAdults;

import java.util.List;


public interface IChildAlertService {
	List<ChildrenAndAdults> getChildAlert(String address) throws Exception;

}
