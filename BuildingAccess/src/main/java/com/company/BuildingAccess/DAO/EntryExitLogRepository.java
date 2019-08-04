package com.company.BuildingAccess.DAO;

import com.company.BuildingAccess.DTO.EntryExitLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EntryExitLogRepository extends JpaRepository<EntryExitLog, Integer> {
    //WAYS TO SEARCH DATABASE AND FIND INFORMATION
    List<EntryExitLog> findByEmployee(String name);
    List<EntryExitLog> findByCompany(String companyName);
}
