package com.promineotech.person.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonSighting {
  private Long personSightingPK;
  private Person person;
  private Sighting sighting;
  private Province province;
  
  @JsonIgnore
  public Long getPersonSightingPK() {
    return personSightingPK;
  }
}
