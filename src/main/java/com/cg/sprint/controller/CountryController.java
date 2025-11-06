package com.cg.sprint.controller;

import com.cg.sprint.dto.CountryDTO;
import com.cg.sprint.dto.LocationDTO;
import com.cg.sprint.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping
    public List<CountryDTO> getAllCountries() {
        return countryService.getAllCountries();
    }

    @GetMapping("/{id}")
    public CountryDTO getCountryById(@PathVariable String id) {
        return countryService.getCountryById(id);
    }

    @GetMapping("/{id}/locations")
    public List<LocationDTO> getLocationsByCountry(@PathVariable String id) {
        return countryService.getLocationsByCountry(id);
    }
}
