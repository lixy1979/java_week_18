package com.promineotech.person.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;

import com.promineotech.person.entity.PersonSighting;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@Sql(scripts = {
    "classpath:flyway/migrations/V1.0__Person_Schema.sql",
    "classpath:flyway/migrations/V1.1__Person_Data.sql"}, 
    config = @SqlConfig(encoding = "utf-8"))
class CreatePersonSightingTest {

	@LocalServerPort
	private int serverPort;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	void testCreatePersonSightingReturnsSuccess201() {
		//Given: an order as JSON
		String body = createPersonSightingBody();
		String uri = String.format("http://localhost:%d/personSighting", serverPort);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
				
		HttpEntity<String> bodyEntity = new HttpEntity<>(body, headers);		
		
		//When: the order is sent
		ResponseEntity<PersonSighting> response = restTemplate.exchange(uri,
			    HttpMethod.POST, bodyEntity, PersonSighting.class);
		
		//Then:a 201 status is returned
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		
		//And: the returned order is correct
		assertThat(response.getBody()).isNotNull();

		PersonSighting personSighting = response.getBody();
		assertThat(personSighting.getPerson().getPersonId()).isEqualTo("YANG_BO");
		assertThat(personSighting.getPerson().getFamilyName()).isEqualTo("YANG");
		assertThat(personSighting.getPerson().getGivenName()).isEqualTo("BO");
		assertThat(personSighting.getPerson().getBirthday()).isEqualTo(LocalDate.parse("2018-12-01"));
		assertThat(personSighting.getPerson().getGender()).isEqualTo("male");
		assertThat(personSighting.getPerson().getMissingDate()).isEqualTo(LocalDate.parse("2022-1-28"));
		assertThat(personSighting.getPerson().getHomeProvinceId()).isEqualTo("HENAN");
		
		assertThat(personSighting.getSighting().getSightingId()).isEqualTo("YANG_BO");
		assertThat(personSighting.getSighting().getSightingDate()).isEqualTo(LocalDate.parse("2022-3-15"));
		assertThat(personSighting.getSighting().getSightingProvinceId()).isEqualTo("GUIZHOU");
		
	}
	protected String createPersonSightingBody() {
	// @formatter:off
		return "{\n"
	    + "  \"personId\":\"YANG_BO\",\n"
	    + "  \"familyName\":\"YANG\",\n"
	    + "  \"givenName\":\"BO\",\n"
	    + "  \"birthday\":\"2018-12-01\",\n"
	    + "  \"gender\":\"male\",\n"
	    + "  \"missingDate\":\"2022-1-28\",\n"
	    + "  \"homeProvince\":\"HENAN\",\n"
	    + "  \"sightingId\":\"YANG_BO\",\n"
	    + "  \"sightingDate\":\"2022-3-15\",\n"
	    + "  \"sightingProvince\":\"GUIZHOU\"\n"
	    + "}";
	//@formatter:on
	}
	
}
