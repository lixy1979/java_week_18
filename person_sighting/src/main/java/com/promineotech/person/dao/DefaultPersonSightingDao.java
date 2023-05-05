package com.promineotech.person.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.promineotech.person.entity.Person;
import com.promineotech.person.entity.PersonSighting;
import com.promineotech.person.entity.Province;
import com.promineotech.person.entity.Sighting;

@Component
public class DefaultPersonSightingDao implements PersonSightingDao {

	@Autowired
	  private NamedParameterJdbcTemplate jdbcTemplate;
	  
	  @Override
	  public PersonSighting savePersonSighting(Person person, Sighting sighting) {
		  SqlParams params = generateInsertSql(person, sighting);
		  
		  KeyHolder keyHolder = new GeneratedKeyHolder();
		  jdbcTemplate.update(params.sql, params.source,keyHolder);
		  Long personSightingPk = keyHolder.getKey().longValue(); 
		  
		  
		  //@formatter:off
		  return PersonSighting.builder()
				  .personSightingPK(personSightingPk)
				  .person(person)
				  .sighting(sighting)
				  .build();
		  //@formatter:on
	 };
	  
	 
	 /**
	  * 
	  * @param person
	  * @param sighting
	  * @param province
	  * @return
	  */
	  private SqlParams generateInsertSql(Person person, Sighting sighting) {
	    // @formatter:off
	    String sql = ""
	        + "INSERT INTO person_sighting ("
	        + "person_fk, sighting_fk"
	        + ") VALUES ("
	        + ":person_fk, :sighting_fk"
	        + ")";
	    // @formatter:on
	    
	    SqlParams params = new SqlParams();
	    
	    params.sql = sql;
	    params.source.addValue("person_fk", person.getPersonPK());
	    params.source.addValue("sighting_fk", sighting.getSightingPK());
	        
	    return params;
	  }
	  /**
	   * 
	   */
	  @Override
	  public Optional<Person> fetchPerson(String personId) {
	    // @formatter:off
	    String sql = "" 
	        + "SELECT * " 
	        + "FROM person "
	        + "WHERE person_id = :person_id ";
//	        + "AND family_name = :family_name "
//	        + "AND given_name = :given_name"
//	        + "AND birthday = :birthday"
//	        + "AND gender = :gender"
//	        + "AND missing_date = :missing_date"
//	        + "AND Home_province_id = :Home_province_id";
	    // @formatter:on

	    Map<String, Object> params = new HashMap<>();
	    params.put("person_id", personId);
//	    params.put("family_name", familyName);
//	    params.put("given_name", givenName);
//	    params.put("birthday", birthday);
//	    params.put("gender", gender);
//	    params.put("missing_date", missingDate);
//	    params.put("Home_province_id", homeProvinceId);

	    return Optional.ofNullable(
		        jdbcTemplate.query(sql, params, new PersonResultSetExtractor()));
	  }

	  /**
	   * 
	   */
	  @Override
	  public Optional<Sighting> fetchSighting(String sightingId) {
	    // @formatter:off
	    String sql = "" 
	        + "SELECT * " 
	        + "FROM sighting " 
	        + "WHERE sighting_id = :sighting_id ";
//	        + "AND sighting_date = :sighting_date"
//	        + "AND sighting_province_id = :sighting_province_id";
	        
	        
	    
	    // @formatter:on

	    Map<String, Object> params = new HashMap<>();
	    params.put("sighting_id", sightingId);
//	    params.put("sighting_date", sightingDate);
//	    params.put("sighting_province_id", sightingProvinceId);
	    return Optional.ofNullable(
	        jdbcTemplate.query(sql, params, new SightingResultSetExtractor()));
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
	          .birthday(rs.getDate("birthday").toLocalDate())
	          .gender(rs.getString("gender"))
	          .missingDate(rs.getDate("missing_date").toLocalDate())
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
	          .sightingDate(rs.getDate("sighting_date").toLocalDate())
	          .sightingProvinceId(rs.getString("Home_province_id"))
	          .build();
	      // @formatter:on
	    }
	  }

                                      
	

	  class SqlParams {
	    String sql;
	    MapSqlParameterSource source = new MapSqlParameterSource();
	  }


}
