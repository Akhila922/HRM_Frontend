package com.cg.hrms.dto;

import java.util.List;

public class CountryDtoSwathi {
    private String countryName;
    private List<String> cities;

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public List<String> getCities() {
        return cities;
    }

    public void setCities(List<String> cities) {
        this.cities = cities;
    }
}

