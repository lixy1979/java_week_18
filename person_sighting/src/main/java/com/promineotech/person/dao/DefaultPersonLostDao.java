package com.promineotech.person.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import com.promineotech.person.entity.Person;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultPersonLostDao implements PersonLostDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Override
	public List<Person> fetchPerson(String personId, String homeProvinceId, String gender) {
		log.debug("DAO: personId = {}, provinceId = {}, gender = {}", personId,
				homeProvinceId, gender);
		
		// @formatter: off
		String sql = ""
		+ "SELECT * "
		+ "FROM person "
		+ "WHERE person_id = :person_id AND Home_province_id = :Home_province_id AND gender = :gender";
		// @formatter: on
		Map<String, Object> params = new HashMap<>();
		params.put("person_id", personId);
		params.put("Home_province_id", homeProvinceId);
		params.put("gender", gender);
		return jdbcTemplate.query(sql, params, new RowMapper<>(){

		@Override
		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
		//@formatter:off
		return Person.builder()
		.personPK(rs.getLong("person_Pk"))
		.personId(rs.getString("person_id"))
		.familyName(rs.getString("family_name"))
		.givenName(rs.getString("given_name"))
		.birthday(rs.getDate("birthday").toLocalDate())
		.gender(rs.getString("gender"))
		.missingDate(rs.getDate("missing_date").toLocalDate())
		.homeProvinceId(rs.getString("Home_province_id"))
		.build();
		//@formatter:on
		}});
	}

}
