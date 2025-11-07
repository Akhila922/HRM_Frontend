package com.cg.hrms.dto;

import java.util.List;

public class RegionWithCountriesDto {
  private Long regionId;
  private String regionName;
  private List<String> countryNames;

  public RegionWithCountriesDto(Long regionId, String regionName, List<String> countryNames) {
    this.regionId = regionId;
    this.regionName = regionName;
    this.countryNames = countryNames;
  }

  public Long getRegionId() { return regionId; }
  public String getRegionName() { return regionName; }
  public List<String> getCountryNames() { return countryNames; }
}
