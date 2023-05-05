package com.promineotech.person.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.person.dao.PersonLostDao;
import com.promineotech.person.entity.Person;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultPersonLostService implements PersonLostService {
	
	@Autowired
	private PersonLostDao personSightingDao;
	
	@Override
	public List<Person> fetchPerson(String personId, String homeProvinceId, String gender) {
		log.debug("The fetchPerson method was called with personId = {}," +
				"and provinceId = {}," + "and gender = {}", personId, 
				homeProvinceId, gender);

		return personSightingDao.fetchPerson(personId, homeProvinceId, gender);
	}

}
