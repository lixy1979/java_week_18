package com.promineotech.person.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.person.entity.PersonSighting;
import com.promineotech.person.entity.PersonSightingRequest;
import com.promineotech.person.service.PersonSightingService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultPersonSightingController implements PersonSightingController {

	@Autowired
	private PersonSightingService personSightingService;
	
	@Override
	public PersonSighting createPersonSighting(PersonSightingRequest personSightingRequest) {
		log.debug("PersonSighting={}", personSightingRequest);
		return personSightingService.createPersonSighting(personSightingRequest);
	}
}
