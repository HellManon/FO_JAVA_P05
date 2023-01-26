package com.safetynet.alerts.controller.enpoints;

import com.safetynet.alerts.service.endpoints.PersonInfoService;
import com.safetynet.alerts.dto.PersonInfo;

import java.util.List;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller mapping GET for PersonInfoService and PersonInfo endpoint
 */
@Data
@RestController
public class PersonInfoController {

    @Autowired
    PersonInfoService service;

    @GetMapping("/personInfo")
    public List<PersonInfo> getPersonInfo(@RequestParam String firstName, @RequestParam String lastName) {
        return service.getPersonInfo(firstName, lastName);
    }
}

