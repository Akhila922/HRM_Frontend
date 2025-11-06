package com.cg.hr.entity;
 
import jakarta.persistence.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
 
@Entity
@Table(name = "locations")
public class Location {
 
    // Version A: locationId
    @Column(name = "location_id", insertable = false, updatable = false)
    private Long locationId;
 
    // Version B: id (used as @Id)
    @Id
    @Column(name = "location_id")
    private Long id;
 
    // Shared: city
    @Column(name = "city", nullable = false)
    private String city;
 
    // Version B: street address
    @Column(name = "street_address")
    private String streetAddress;
 
    // Version B: postal code
    @Column(name = "postal_code")
    private String postalCode;
 
    // Version B: state province
    @Column(name = "state_province")
    private String stateProvince;
 
    // Version A: country reference
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
 
    // Shared: departments
    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Department> departments;
 
    // Getters and Setters
 
    public Long getLocationId() {
        return locationId;
    }
 
    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }
 
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public String getCity() {
        return city;
    }
 
    public void setCity(String city) {
        this.city = city;
    }
 
    public String getStreetAddress() {
        return streetAddress;
    }
 
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }
 
    public String getPostalCode() {
        return postalCode;
    }
 
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
 
    public String getStateProvince() {
        return stateProvince;
    }
 
    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }
 
    public Country getCountry() {
        return country;
    }
 
    public void setCountry(Country country) {
        this.country = country;
    }
 
    public List<Department> getDepartments() {
        return departments;
    }
 
    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }
}