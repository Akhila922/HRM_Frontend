package com.cg.hrms.serviceimpl;

import com.cg.hrms.dto.CountryDtoSwathi;
import com.cg.hrms.entity.Country;
import com.cg.hrms.repositories.CountryRepositorySwathi;
import com.cg.hrms.service.CountryServiceSwathi;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryServiceImplSwathi implements CountryServiceSwathi {

    private final CountryRepositorySwathi repo;

    public CountryServiceImplSwathi(CountryRepositorySwathi repo) {
        this.repo = repo;
    }
    
    @Override
    public List<CountryDtoSwathi> getAllCountriesWithCities() {
        return repo.findAll().stream().map(country -> {
            CountryDtoSwathi dto = new CountryDtoSwathi();
            dto.setCountryName(country.getCountryName());
            dto.setCities(
                    country.getLocations().stream()
                            .map(loc -> loc.getCity())
                            .distinct()
                            .sorted(String::compareToIgnoreCase)
                            .collect(Collectors.toList())
            );
            return dto;
        }).collect(Collectors.toList());
    }

}
