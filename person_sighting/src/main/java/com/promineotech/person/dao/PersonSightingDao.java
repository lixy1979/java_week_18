package com.promineotech.person.dao;

import java.util.Optional;

import com.promineotech.person.entity.Person;
import com.promineotech.person.entity.PersonSighting;
import com.promineotech.person.entity.Sighting;

public interface PersonSightingDao {
	  Optional<Person> fetchPerson(String personId);
	  Optional<Sighting> fetchSighting(String sightingId);
	 
	  PersonSighting savePersonSighting(Person person, Sighting sighting);
}
