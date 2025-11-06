package com.cg.hrms.entity;

import jakarta.persistence.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "countries")
public class Country {

    // Used by System A: shadow field for countryId
    @Column(name = "country_id", insertable = false, updatable = false)
    private String countryId;

    // Used by System B: primary key
    @Id
    @Column(name = "country_id", length = 4)
    private String id;

    // Used by System A: shadow field for countryName
    @Column(name = "country_name", insertable = false, updatable = false)
    private String countryName;

    // Used by System B: main name field
    @Column(name = "country_name", length = 60)
    private String name;

    // Used by System B: region reference
    @Column(name = "region_id")
    private Long regionId;

    // Shared: locations mapped by 'country' field in Location entity
    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    @JsonIgnore // suppress in one system
    @JsonManagedReference // enable in another system
    private List<Location> locations;

    // Getters and Setters

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }
}
