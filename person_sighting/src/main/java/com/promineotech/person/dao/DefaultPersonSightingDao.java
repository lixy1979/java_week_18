package com.promineotech.person.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.promineotech.person.entity.Person;
import com.promineotech.person.entity.PersonSighting;

import com.promineotech.person.entity.Sighting;

@Component
public class DefaultPersonSightingDao implements PersonSightingDao {

	@Autowired
	  private NamedParameterJdbcTemplate jdbcTemplate;
	  
	  @Override
	  public PersonSighting savePersonSighting(Sighting sighting, Person person) {
		  
		  SqlParams params = generateInsertSql(sighting,person);
		  
		  KeyHolder keyHolder = new GeneratedKeyHolder();
		  jdbcTemplate.update(params.sql, params.source,keyHolder);
		  Long personSightingPk = keyHolder.getKey().longValue(); 
		  
		  
		  //@formatter:off
		  return PersonSighting.builder()
				  .personSightingPK(personSightingPk)
				  .sighting(sighting)
				  .person(person)
				  .build();
		  //@formatter:on
	 };
	  
	 
	 /**
	  * 
	  * @param person
	  * @param sighting
	  * @param 
	  * @return
	  */
	  private SqlParams generateInsertSql(Sighting sighting, Person person) {
	    // @formatter:off
	    String sql = ""
	        + "INSERT INTO person_sighting ("
	        + "sighting_fk, person_fk"
	        + ") VALUES ("
	        + ":sighting_fk, :person_fk"
	        + ")";
	    // @formatter:on
	    
	    SqlParams params = new SqlParams();
	    
	    params.sql = sql;
	    params.source.addValue("sighting_fk", sighting.getSightingPK());
	    params.source.addValue("person_fk", person.getPersonPK());
	        
	    return params;
	  }
	  /**
	   * 
	   */
	  @Override
	  public Person fetchPerson(String personId) {
	    // @formatter:off
	    String sql = "" 
	        + "SELECT * " 
	        + "FROM person "
	        + "WHERE person_id = :person_id ";

	    // @formatter:on

	    Map<String, Object> params = new HashMap<>();
	    params.put("person_id", personId);


	    return jdbcTemplate.query(sql, params, new PersonResultSetExtractor());
	  }

	  /**
	   * 
	   */
	  @Override
	  public Sighting fetchSighting(String sightingId) {
	    // @formatter:off
	    String sql = "" 
	        + "SELECT * " 
	        + "FROM sighting " 
	        + "WHERE sighting_id = :sighting_id ";

	        
	        
	    
	    // @formatter:on

	    Map<String, Object> params = new HashMap<>();
	    params.put("sighting_id", sightingId);

	    return jdbcTemplate.query(sql, params, new SightingResultSetExtractor());
	  }


	 

	  /**
	   * 
	   * @author Promineo
	   *
	   */
	  class PersonResultSetExtractor implements ResultSetExtractor<Person> {
	    @Override
	    public Person extractData(ResultSet rs) throws SQLException {
	      rs.next();

	      // @formatter:off
	      return Person.builder()
	          .personId(rs.getString("person_id"))
	          .familyName(rs.getString("family_name"))
	          .givenName(rs.getString("given_name"))
//	          .birthday(rs.getDate("birthday").toLocalDate())
	          .gender(rs.getString("gender"))
//	          .missingDate(rs.getDate("missing_date").toLocalDate())
	          .homeProvinceId(rs.getString("Home_province_id"))
	          .build();
	      // @formatter:on
	    }
	  }

	  /**
	   * 
	   * @author Promineo
	   *
	   */
	  class SightingResultSetExtractor implements ResultSetExtractor<Sighting> {
	    @Override
	    public Sighting extractData(ResultSet rs) throws SQLException {
	      rs.next();

	      // @formatter:off
	      return Sighting.builder()
	          .sightingId(rs.getString("sighting_id"))
//	          .sightingDate(rs.getDate("sighting_date").toLocalDate())
	          .sightingProvinceId(rs.getString("sighting_province_id"))
	          .build();
	      // @formatter:on
	    }
	  }

                                      
	

	  class SqlParams {
	    String sql;
	    MapSqlParameterSource source = new MapSqlParameterSource();
	  }


}
