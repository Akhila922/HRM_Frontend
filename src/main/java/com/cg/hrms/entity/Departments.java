package com.cg.hrms.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "departments")
public class Department {

    @Id
    @Column(name = "department_id")
    private Long id;

    @Column(name = "department_name", nullable = false)
    private String name;

    @Column(name = "manager_id")
    private Long managerId;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "location_id")
    private Location location;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Employee> employees;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Long getManagerId() { return managerId; }
    public void setManagerId(Long managerId) { this.managerId = managerId; }

    public Location getLocation() { return location; }
    public void setLocation(Location location) { this.location = location; }

    public List<Employee> getEmployees() { return employees; }
    public void setEmployees(List<Employee> employees) { this.employees = employees; }
}
