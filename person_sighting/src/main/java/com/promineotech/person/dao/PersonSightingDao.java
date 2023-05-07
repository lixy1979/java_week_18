package com.promineotech.person.dao;

import com.promineotech.person.entity.Person;
import com.promineotech.person.entity.PersonSighting;
import com.promineotech.person.entity.Sighting;

public interface PersonSightingDao {
	 Person fetchPerson(String personId);
	 Sighting fetchSighting(String sightingId);
	 PersonSighting savePersonSighting(Sighting sighting, Person person);
}
