package com.company.BuildingAccess.DAO;


import com.company.BuildingAccess.DTO.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    //WAYS TO SEARCH DATABASE AND FIND INFORMATION
    List<Employee> findByName(String name);
    List<Employee> findByTitle(String title);
    List<Employee> findByHireDate(String hireDate);
    List<Employee> findByCompany(String company);
}
