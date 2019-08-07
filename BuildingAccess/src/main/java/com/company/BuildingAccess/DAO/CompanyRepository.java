package com.company.BuildingAccess.DAO;

import com.company.BuildingAccess.DTO.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


public interface CompanyRepository extends JpaRepository<Company, Integer> {
    //WAYS TO SEARCH DATABASE AND FIND INFORMATION
    List<Company> findByName(String name);
    List<Company> findByFloor(Integer floor);

}
