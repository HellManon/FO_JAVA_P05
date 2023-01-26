package com.safetynet.alerts.service.endpoints;

import com.safetynet.alerts.dao.JSONReader;
import com.safetynet.alerts.dao.Reader;
import com.safetynet.alerts.dto.PhoneWithName;
import com.safetynet.alerts.model.FireStation;
import com.safetynet.alerts.model.Person;
import lombok.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Service that allows to get a person's list with their name and phone number, from specified station.
 */
@Data
@Service
public class PhoneAlertService implements IPhoneAlertService {
    private static final Logger logger = LogManager.getLogger("PhoneAlertService");

    @Autowired
    JSONReader jsonReader;

    private List<Person> listPerson;
    private Map<String, FireStation> map;

    public PhoneAlertService(Reader jsonReader) throws IOException {
        this.listPerson = jsonReader.readPerson();
        this.map = jsonReader.readFireStation();
    }

    public List<PhoneWithName> getPhoneAlert(String station) {
        logger.debug("Entering getPhoneAlert");
        List<PhoneWithName> listPhone = map.get(station).getAddresses().stream()
                .flatMap(address -> listPerson.stream()
                        .filter(person -> person.getAddress().contains(address))
                        .map(phoneWithName ->
                        {
                            PhoneWithName phoneWithName1 = new PhoneWithName();
                            phoneWithName1.setFirstName(phoneWithName.getFirstName());
                            phoneWithName1.setLastName(phoneWithName.getLastName());
                            phoneWithName1.setPhone(phoneWithName.getPhone());
                            return phoneWithName1;
                        })).collect(Collectors.toList());
        logger.info("Phone data find successfully");
        return listPhone;
    }
}
