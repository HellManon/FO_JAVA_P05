package com.safetynet.alert.dto;

import lombok.Data;

import java.util.List;

@Data
public class FireCoverage {
    private List<PersonCover> personCoverList;
    private int numberOfAdults;
    private int numberOfChildren;

    public FireCoverage(List<PersonCover> personCoverList, int numberOfAdults, int numberOfChildren) {
        this.personCoverList = personCoverList;
        this.numberOfAdults = numberOfAdults;
        this.numberOfChildren = numberOfChildren;
    }

}
