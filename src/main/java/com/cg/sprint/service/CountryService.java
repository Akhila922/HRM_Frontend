package com.cg.sprint.service;

import com.cg.sprint.dto.CountryDTO;
import com.cg.sprint.dto.LocationDTO;
import com.cg.sprint.dto.RegionWithCountriesDto;
import java.util.List;

public interface CountryService {
  List<CountryDTO> getAllCountries();
  CountryDTO getCountryById(String id);
  List<LocationDTO> getLocationsByCountry(String countryId);

  // NEW
  List<RegionWithCountriesDto> getRegionsWithCountries();
}
