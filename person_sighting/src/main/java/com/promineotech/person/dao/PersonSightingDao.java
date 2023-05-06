package com.promineotech.person.dao;

import java.util.Optional;

import com.promineotech.person.entity.Person;
import com.promineotech.person.entity.PersonSighting;
import com.promineotech.person.entity.Sighting;

public interface PersonSightingDao {
	  Optional<Person> fetchPerson(Person person);
	  Optional<Sighting> fetchSighting(Sighting sighting);
	  
	 
	  PersonSighting savePersonSighting(Person person, Sighting sighting);
}
