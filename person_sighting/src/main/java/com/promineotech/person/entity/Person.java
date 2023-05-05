package com.promineotech.person.entity;


import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {
  private Long personPK;
  private String personId;
  private String familyName;
  private String givenName;
  private LocalDate birthday;
  private String gender;
  private LocalDate missingDate;
  private String homeProvinceId;
  
  
  @JsonIgnore
  public Long getPersonPK() {
	return personPK;  
  }
  
}
