package com.promineotech.person.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;

import com.promineotech.person.entity.Person;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@Sql(scripts = {
    "classpath:flyway/migrations/V1.0__Person_Schema.sql",
    "classpath:flyway/migrations/V1.1__Person_Data.sql"}, 
    config = @SqlConfig(encoding = "utf-8"))
class FetchPersonTest {
	
	 @Autowired
	  private TestRestTemplate restTemplate;
	  
	  @LocalServerPort
	  private int serverPort;
	  
		protected List<Person> buildExpected() {
			List<Person> list = new LinkedList<>();
			list.add(Person.builder()
					.personId("YANG_BO")
					.familyName("Yang")
					.givenName("Bo")
					.birthday(LocalDate.parse("2018-12-01"))
					.gender("male")
					.missingDate(LocalDate.parse("2022-01-28"))
					.homeProvinceId("HENAN")
					.build());
			
			return list;
		}

	@Test
	void testThatPersonAreReturnedWhenAValidNameAndGenderAreSupplied() {
		// Given: a valid model, trim and URI
		String personId = "YANG_BO";
		String homeProvinceId = "HENAN";
		String gender = "male";
		String uri = 
			String.format("http://localhost:%d/person?personId=%s&homeProvinceId=%s&gender=%s", serverPort, 
					personId, homeProvinceId, gender);
	    System.out.println(uri);
	// When: a connection is made to the URI
		
        ResponseEntity<List<Person>> response =
			    		  restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<>(){});
	// Then: a success (OK - 200) status code is returned
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		
	// And: the actual list returned is the same as the expected list.
		List<Person> actual = response.getBody();
		List<Person> expected = buildExpected();
		
		assertThat(actual).isEqualTo(expected);		
	}


}
