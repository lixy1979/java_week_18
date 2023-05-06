package com.promineotech.person.entity;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class PersonSightingRequest {
	
	  @NotNull
	  private Person person;
	  
	  @NotNull
	  @Length(max = 30)
	  @Pattern(regexp = "[\\w\\s]*")
	  private String personId;
	  
	  
	  @NotNull
	  @Length(max = 30)
	  @Pattern(regexp = "[\\w\\s]*")
	  private String familyName;
	  
	  @NotNull
	  @Length(max = 30)
	  @Pattern(regexp = "[\\w\\s]*")
	  private String givenName;
	  
	  @PastOrPresent
      @NotNull
      @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	  private LocalDate birthday;
	  
	  @NotNull
	  @Length(max = 30)
	  @Pattern(regexp = "[\\w\\s]*")
	  private String gender;
	  
	  @PastOrPresent
      @NotNull
      @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	  private LocalDate missingDate;
	  
	  @NotNull
	  @Length(max = 30)
	  @Pattern(regexp = "[\\w\\s]*")
	  private String homeProvince;
	 
	 @NotNull
	  private Sighting sighting;
	 
	  @NotNull
	  @Length(max = 30)
	  @Pattern(regexp = "[\\w\\s]*")
	  private String sightingId;
	 
	  @PastOrPresent
      @NotNull
      @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	 private LocalDate sightingDate;
	 
	  @NotNull
	  @Length(max = 30)
	  @Pattern(regexp = "[\\w\\s]*")
	  private String sightingProvince;
}
