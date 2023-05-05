package com.promineotech.person.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.person.entity.Person;
import com.promineotech.person.service.PersonLostService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultPersonLostController implements PersonLostController {
	
	@Autowired
	private PersonLostService personSightingService;

	@Override
	public List<Person> fetchPerson(String personId, String homeProvinceId, String gender) {
		log.debug("personId = {}, provinceId = {}, gender = {}", personId,
				homeProvinceId, gender);
		return personSightingService.fetchPerson(personId, homeProvinceId, gender);
		
	}

}
