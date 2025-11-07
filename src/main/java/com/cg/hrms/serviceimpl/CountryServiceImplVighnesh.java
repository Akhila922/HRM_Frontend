package com.cg.hrms.serviceimpl;

import com.cg.hrms.dto.RegionWithCountriesDto;
import com.cg.hrms.entity.Country;
import com.cg.hrms.repositories.CountryRepositoryVighnesh;
import com.cg.hrms.service.CountryServiceVighnesh;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CountryServiceImplVighnesh implements CountryServiceVighnesh {

  private final CountryRepositoryVighnesh countryRepo;

  public CountryServiceImplVighnesh(CountryRepositoryVighnesh countryRepo) {
    this.countryRepo = countryRepo;
  }

  @Override
  public List<RegionWithCountriesDto> getRegionsWithCountries() {
    List<Country> all = countryRepo.findAll();
    Map<Long, RegionWithCountriesDto> map = new LinkedHashMap<>();

    for (Country c : all) {
      if (c.getRegion() == null) continue;
      Long regionId = c.getRegion().getId();
      String regionName = c.getRegion().getName();

      map.computeIfAbsent(regionId,
          id -> new RegionWithCountriesDto(id, regionName, new ArrayList<>()))
         .getCountryNames().add(c.getCountryName());
    }

    map.values().forEach(rc -> rc.getCountryNames().sort(String::compareToIgnoreCase));
    return new ArrayList<>(map.values());
  }
}
