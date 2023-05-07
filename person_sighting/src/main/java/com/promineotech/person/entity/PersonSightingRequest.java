package com.promineotech.person.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import lombok.Data;

@Data
public class PersonSightingRequest {
	

	  
	  @NotNull
	  @Length(max = 30)
	  @Pattern(regexp = "[\\w\\s]*")
	  private String person;
	  
	  
//	  @NotNull
//	  @Length(max = 30)
//	  @Pattern(regexp = "[\\w\\s]*")
//	  private String familyName;
	  
//	  @NotNull
//	  @Length(max = 30)
//	  @Pattern(regexp = "[\\w\\s]*")
//	  private String givenName;
	  
//	  @PastOrPresent
//      @NotNull
//      @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
//	  private LocalDate birthday;
	  
//	  @NotNull
//	  @Length(max = 30)
//	  @Pattern(regexp = "[\\w\\s]*")
//	  private String gender;
//	  
//	  @PastOrPresent
//      @NotNull
//      @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
//	  private LocalDate missingDate;
	  
//	  @NotNull
//	  @Length(max = 30)
//	  @Pattern(regexp = "[\\w\\s]*")
//	  private String homeProvince;
	 
 
	  @NotNull
	  @Length(max = 30)
	  @Pattern(regexp = "[\\w\\s]*")
	  private String sighting;
	 
//	  @PastOrPresent
//      @NotNull
//      @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
//	 private LocalDate sightingDate;
	 
//	  @NotNull
//	  @Length(max = 30)
//	  @Pattern(regexp = "[\\w\\s]*")
//	  private String sightingProvince;


	
}
