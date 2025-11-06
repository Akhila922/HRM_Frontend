package com.cg.sprint.repository;


import com.cg.sprint.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    // Find departments by location
    List<Department> findByLocation_LocationId(Long locationId);

    // Find departments by manager
    List<Department> findByManager_EmployeeId(Long managerId);
}
