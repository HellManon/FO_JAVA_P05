package com.safetynet.alerts.service.endpoints;

import com.safetynet.alerts.dao.JSONReader;
import com.safetynet.alerts.dao.Reader;
import com.safetynet.alerts.dto.PhoneAndMedical;
import com.safetynet.alerts.dto.PhoneAndMedicalByAddress;
import com.safetynet.alerts.dto.StationAndAddress;
import com.safetynet.alerts.model.FireStation;
import com.safetynet.alerts.model.MedicalRecord;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.service.PersonAge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Service that allows to get a fire station's list with address's list that contains person's info of inhabitant, from list of specified fire station.
 */

@Service
public class FloodService implements IFloodService {
    private static final Logger logger = LogManager.getLogger("FloodService");

    @Autowired
    JSONReader jsonReader;

    PersonAge personAge = new PersonAge();

    private List<Person> listPerson;
    private Map<String, FireStation> map;
    private List<MedicalRecord> listMedical;

    public FloodService(Reader jsonReader) throws IOException {
        this.listPerson = jsonReader.readPerson();
        this.listMedical = jsonReader.readMedicalRecord();
        this.map = jsonReader.readFireStation();
    }

    public List<StationAndAddress> getFlood(List<String> stations) {
        logger.debug("Entering getFlood");
        List<StationAndAddress> getFlood = stations.stream().map(station ->
        {
            logger.debug("Create List of Addresses");
            StationAndAddress stationAndAddress = new StationAndAddress();
            stationAndAddress.setStation(station);
            stationAndAddress.setAddress(
                    map.get(station).getAddresses().stream()
                            .map(address ->
                            {
                                logger.debug("Create List of Person by Address");
                                PhoneAndMedicalByAddress phoneAndMedicalByAddress = new PhoneAndMedicalByAddress();
                                phoneAndMedicalByAddress.setAddress(address);
                                phoneAndMedicalByAddress.setPhoneAndMedicalList(listPerson.stream().filter(person -> person.getAddress().contains(address))
                                        .flatMap(person -> listMedical.stream()
                                                .filter(medicalRecord -> medicalRecord.getFirstName().contains(person.getFirstName()) && medicalRecord.getLastName().contains(person.getLastName()))
                                                .map(personAndMedical ->
                                                {
                                                    PhoneAndMedical phoneAndMedical = new PhoneAndMedical();
                                                    phoneAndMedical.setFirstName(personAndMedical.getFirstName());
                                                    phoneAndMedical.setLastName(personAndMedical.getLastName());
                                                    phoneAndMedical.setPhone(person.getPhone());
                                                    phoneAndMedical.setAge(String.valueOf(personAge.getPersonAge(personAndMedical.getBirthDate())));
                                                    phoneAndMedical.setMedications(personAndMedical.getMedications());
                                                    phoneAndMedical.setAllergies(personAndMedical.getAllergies());
                                                    return phoneAndMedical;
                                                })).collect(Collectors.toList()));
                                logger.debug("Success List of Person");
                                return phoneAndMedicalByAddress;
                            }).collect(Collectors.toList()));
            logger.debug("Success List of Address");
            return stationAndAddress;
        }).collect(Collectors.toList());
        logger.info("Flood data find successfully");
        return getFlood;
    }
}
