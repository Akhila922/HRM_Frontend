package com.cg.sprint.controller;

import com.cg.sprint.dto.RegionDTO;
import com.cg.sprint.dto.CountryDTO;
import com.cg.sprint.dto.RegionWithCountriesDto;
import com.cg.sprint.service.RegionService;
import com.cg.sprint.service.CountryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/regions")
@Tag(name = "Regions")
public class RegionController {

  @Autowired
  private RegionService regionService;

  @Autowired
  private CountryService countryService; // NEW

  @GetMapping
  public List<RegionDTO> getAllRegions() {
    return regionService.getAllRegions();
  }

  @GetMapping("/{id}")
  public RegionDTO getRegionById(@PathVariable Long id) {
    return regionService.getRegionById(id);
  }

  @GetMapping("/{id}/countries")
  public List<CountryDTO> getCountriesByRegion(@PathVariable Long id) {
    return regionService.getCountriesByRegion(id);
  }

  // NEW
  @GetMapping("/with-countries")
  @Operation(summary = "Regions + Countries list (landing data)")
  public List<RegionWithCountriesDto> withCountries() {
    return countryService.getRegionsWithCountries();
  }
}
