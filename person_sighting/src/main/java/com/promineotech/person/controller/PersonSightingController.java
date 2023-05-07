package com.promineotech.person.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.promineotech.person.entity.PersonSighting;
import com.promineotech.person.entity.PersonSightingRequest;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.Parameter;

@RequestMapping("/personSighting")
@OpenAPIDefinition(info = @Info(title = "PersonSighting service"), servers = {
@Server(url = "http://localhost:8080",description = "local server.")})
@Validated
public interface PersonSightingController {
	//@formatter:off
	@Operation(
			summary = "Create a PersonSighting",
			description = "returns the created PersonSighting",
			responses = {
					@ApiResponse(
							responseCode = "201", 
							description = "The created PersonSighting is returned", 
							content = @Content(mediaType = "application/json",
							schema =@Schema(implementation = PersonSighting.class))),						
					@ApiResponse(
							responseCode = "400", 
							description = "The request parameters are invalid", 
							content = @Content(mediaType = "application/json")
							),
					@ApiResponse(
							responseCode = "404", 
							description = "A PersonSighting component was not found with the input criteria", 
							content = @Content(mediaType = "application/json")
							),
					@ApiResponse(
							responseCode = "500", 
							description = "An unplanned error occurred",
							content = @Content(mediaType = "application/json")
							)
			},
			parameters = {
					@Parameter(
							name = "personSightingRequest", 
							required = true,
							description = "The personSighting as JSON"),
			}
			)
	  @PostMapping
	  @ResponseStatus(code = HttpStatus.CREATED)
	  PersonSighting createPersonSighting(
			  @Valid@RequestBody PersonSightingRequest personSightingRequest 
			  );
       //@formatter:on

}
