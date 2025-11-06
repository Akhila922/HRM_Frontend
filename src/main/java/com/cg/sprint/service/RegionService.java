package com.cg.sprint.service;

import com.cg.sprint.dto.RegionDTO;
import com.cg.sprint.dto.CountryDTO;
import java.util.List;

public interface RegionService {
    List<RegionDTO> getAllRegions();
    RegionDTO getRegionById(Long id);
    List<CountryDTO> getCountriesByRegion(Long regionId);
}