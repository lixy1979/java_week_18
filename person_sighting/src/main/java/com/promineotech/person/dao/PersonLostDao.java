package com.promineotech.person.dao;

import java.util.List;

import com.promineotech.person.entity.Person;

public interface PersonLostDao {
	List<Person> fetchPerson(String personId, String homeProvinceId, String gender);
}
