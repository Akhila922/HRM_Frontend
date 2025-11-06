package com.cg.sprint.serviceimpl;

import com.cg.sprint.dto.CountryDTO;
import com.cg.sprint.dto.LocationDTO;
import com.cg.sprint.entity.Country;
import com.cg.sprint.entity.Location;
import com.cg.sprint.repository.CountryRepository;
import com.cg.sprint.repository.LocationRepository;
import com.cg.sprint.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public List<CountryDTO> getAllCountries() {
        return countryRepository.findAll()
                .stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public CountryDTO getCountryById(String id) {
        return countryRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    @Override
    public List<LocationDTO> getLocationsByCountry(String countryId) {
        List<Location> locations = locationRepository.findByCountry_CountryId(countryId);
        return locations.stream().map(this::convertLocationToDTO).collect(Collectors.toList());
    }

    private CountryDTO convertToDTO(Country country) {
        CountryDTO dto = new CountryDTO();
        dto.setCountryId(country.getCountryId());
        dto.setCountryName(country.getCountryName());
        dto.setRegionId(country.getRegion() != null ? country.getRegion().getRegionId() : null);
        return dto;
    }

    private LocationDTO convertLocationToDTO(Location loc) {
        LocationDTO dto = new LocationDTO();
        dto.setLocationId(loc.getLocationId());
        dto.setStreetAddress(loc.getStreetAddress());
        dto.setPostalCode(loc.getPostalCode());
        dto.setCity(loc.getCity());
        dto.setStateProvince(loc.getStateProvince());
        dto.setCountryId(loc.getCountry() != null ? loc.getCountry().getCountryId() : null);
        return dto;
    }
}