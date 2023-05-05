package com.promineotech.person.service;

import com.promineotech.person.entity.PersonSighting;
import com.promineotech.person.entity.PersonSightingRequest;

public interface PersonSightingService {

	PersonSighting createPersonSighting(PersonSightingRequest personSightingRequest);

}
