package com.safetynetalerts.dto;

import java.util.List;
import lombok.Data;

@Data
public class ChildrenAndAdults {
	private List<Child> childList;
	private List<Adult> adultList;

	public ChildrenAndAdults(List<Child> childList, List<Adult> adultList) {
		this.childList = childList;
		this.adultList = adultList;
	}

}
