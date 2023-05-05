package com.promineotech.person.entity;


import java.time.LocalDate;
import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Sighting {
  private Long sightingPK;
  private String sightingId;
  private LocalDate sightingDate;
  private String sightingProvinceId;
}
