package com.promineotech.person.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.promineotech.person.dao.PersonSightingDao;
import com.promineotech.person.entity.Person;
import com.promineotech.person.entity.PersonSighting;
import com.promineotech.person.entity.PersonSightingRequest;

import com.promineotech.person.entity.Sighting;

@Service
public class DefaultPersonSightingService implements PersonSightingService {

	@Autowired
	private PersonSightingDao personSightingDao;
	
	@Transactional
	@Override
	public PersonSighting createPersonSighting(PersonSightingRequest personSightingRequest) {
		
		Sighting sighting = getSighting(personSightingRequest);
		Person person = getPerson(personSightingRequest);
        System.out.println(sighting.getSightingPK());	
		return personSightingDao.savePersonSighting(sighting, person);
		
	}
	  

	  /**
	   * 
	   * @param personSightingRequest
	   * @return
	   */
	  private Person getPerson(PersonSightingRequest personSightingRequest) {
	    return personSightingDao.fetchPerson(personSightingRequest.getPerson());
	  }

	  /**
	   * 
	   * @param personSightingRequest
	   * @return
	   */
	  private Sighting getSighting(PersonSightingRequest personSightingRequest) {
	    return personSightingDao.fetchSighting(personSightingRequest.getSighting());
	  }



}
