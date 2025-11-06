package com.cg.sprint.controller;

import com.cg.sprint.dto.RegionDTO;
import com.cg.sprint.dto.CountryDTO;
import com.cg.sprint.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/regions")
public class RegionController {

    @Autowired
    private RegionService regionService;

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
}