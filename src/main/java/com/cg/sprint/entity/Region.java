package com.cg.sprint.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "regions")
public class Region {

    @Id
    @Column(name = "region_id", precision = 10)
    private Long regionId;

    @Column(name = "region_name", length = 25)
    private String regionName;

    @OneToMany(mappedBy = "region", cascade = CascadeType.ALL)
    private List<Country> countries;

    // Getters and Setters
    public Long getRegionId() { return regionId; }
    public void setRegionId(Long regionId) { this.regionId = regionId; }

    public String getRegionName() { return regionName; }
    public void setRegionName(String regionName) { this.regionName = regionName; }

    public List<Country> getCountries() { return countries; }
    public void setCountries(List<Country> countries) { this.countries = countries; }
}
