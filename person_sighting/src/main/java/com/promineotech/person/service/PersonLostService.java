package com.promineotech.person.service;

import java.util.List;

import com.promineotech.person.entity.Person;

public interface PersonLostService {

	List<Person> fetchPerson(String personId, String homeProvinceId, String gender);

}
