package com.promineotech.person.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.promineotech.person.dao.PersonSightingDao;
import com.promineotech.person.entity.Person;
import com.promineotech.person.entity.PersonSighting;
import com.promineotech.person.entity.PersonSightingRequest;
import com.promineotech.person.entity.Province;
import com.promineotech.person.entity.Sighting;

@Service
public class DefaultPersonSightingService implements PersonSightingService {

	@Autowired
	private PersonSightingDao personSightingDao;
	
	@Transactional
	@Override
	public PersonSighting createPersonSighting(PersonSightingRequest personSightingRequest) {
		Person person = getPerson(personSightingRequest);
		Sighting sighting = getSighting(personSightingRequest);
	
		return personSightingDao.savePersonSighting(person, sighting);
		
	}
	  

	  /**
	   * 
	   * @param personSightingRequest
	   * @return
	   */
	  private Person getPerson(PersonSightingRequest personSightingRequest) {
	    return personSightingDao.fetchPerson(personSightingRequest.getPerson())
	        .orElseThrow(() -> new NoSuchElementException(
	            "Person with ID=" + personSightingRequest.getPerson() + " was not found"));
	  }

	  /**
	   * 
	   * @param personSightingRequest
	   * @return
	   */
	  private Sighting getSighting(PersonSightingRequest personSightingRequest) {
	    return personSightingDao.fetchSighting(personSightingRequest.getSighting())
	        .orElseThrow(() -> new NoSuchElementException(
	            "Sighting with ID=" + personSightingRequest.getSighting() + " was not found"));
	  }



	  
}
