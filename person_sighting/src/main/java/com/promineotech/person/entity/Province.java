package com.promineotech.person.entity;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Province {
  private Long provincePK;
  private String provinceId;
  private String provinceName;
}
