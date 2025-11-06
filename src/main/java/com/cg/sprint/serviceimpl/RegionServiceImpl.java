package com.cg.sprint.serviceimpl;

import com.cg.sprint.dto.RegionDTO;
import com.cg.sprint.dto.CountryDTO;
import com.cg.sprint.entity.Region;
import com.cg.sprint.entity.Country;
import com.cg.sprint.repository.RegionRepository;
import com.cg.sprint.repository.CountryRepository;
import com.cg.sprint.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegionServiceImpl implements RegionService {

    @Autowired
    private RegionRepository regionRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public List<RegionDTO> getAllRegions() {
        return regionRepository.findAll()
                .stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public RegionDTO getRegionById(Long id) {
        return regionRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    @Override
    public List<CountryDTO> getCountriesByRegion(Long regionId) {
        List<Country> countries = countryRepository.findByRegion_RegionId(regionId);
        return countries.stream().map(this::convertCountryToDTO).collect(Collectors.toList());
    }

    private RegionDTO convertToDTO(Region region) {
        RegionDTO dto = new RegionDTO();
        dto.setRegionId(region.getRegionId());
        dto.setRegionName(region.getRegionName());
        return dto;
    }

    private CountryDTO convertCountryToDTO(Country country) {
        CountryDTO dto = new CountryDTO();
        dto.setCountryId(country.getCountryId());
        dto.setCountryName(country.getCountryName());
        dto.setRegionId(country.getRegion() != null ? country.getRegion().getRegionId() : null);
        return dto;
    }
}
