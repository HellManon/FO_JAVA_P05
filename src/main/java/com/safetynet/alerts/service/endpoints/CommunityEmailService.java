	package com.safetynet.alerts.service.endpoints;

	import com.safetynet.alerts.dao.JSONReader;
	import com.safetynet.alerts.dao.Reader;
	import com.safetynet.alerts.dto.EmailWithName;
	import com.safetynet.alerts.model.Person;
	import lombok.Data;
	import org.apache.logging.log4j.LogManager;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	import org.apache.logging.log4j.Logger;

	import java.io.IOException;
	import java.util.List;
	import java.util.stream.Collectors;

	/**
	 * Service that allows to get a email's list from person who lived in specified city.
	 */
	
	@Data
	@Service
	public class CommunityEmailService implements ICommunityEmailService {
	    private static final Logger logger = LogManager.getLogger("CommunityEmailService");

	    @Autowired
	    JSONReader jsonReader;

	    private List<Person> list;

	    public CommunityEmailService(Reader jsonReader) throws IOException {
	        this.list = jsonReader.readPerson();
	    }

	    public List<EmailWithName> getCommunityEmail(String city) {
	        logger.debug("Entering getCommunityEmail");
	        List<EmailWithName> listEmail = list.stream()
	                .filter(person -> person.getCity().contains(city))
	                .map(communityEmail ->
	                {
	                    EmailWithName emailWithName = new EmailWithName();
	                    emailWithName.setFirstName(communityEmail.getFirstName());
	                    emailWithName.setLastName(communityEmail.getLastName());
	                    emailWithName.setEmail(communityEmail.getEmail());
	                    return emailWithName;
	                }).collect(Collectors.toList());

	        logger.info("Community Email find successfully");
	        return listEmail;
	    }
	}


