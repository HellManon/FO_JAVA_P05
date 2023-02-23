package com.safetynet.alert.Controller.enpoints;

import com.safetynet.alert.dto.PersonInfo;
import com.safetynet.alert.service.endpoints.PersonInfoService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

