package com.company.BuildingAccess.Service;

import com.company.BuildingAccess.DAO.EntryExitLogRepository;
import com.company.BuildingAccess.DTO.EntryExitLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@Component
public class EntryExitLogService {
    //LINK TO REPOSITORY/DATABASE
    @Autowired
    private EntryExitLogRepository eelRepo;

    //METHODS

    //ADD ENTRY/EXIT
    public EntryExitLog addEntryExitLog(EntryExitLog entryExitLog){
        eelRepo.save(entryExitLog);
        return entryExitLog;
    }

    //GET ALL ENTRIES AND EXITS
    public List<EntryExitLog> getAllEntryExit(){
        return eelRepo.findAll();
    }

    //GET ENTRIES AND EXITS BY ID
    public EntryExitLog getEntryExitById(int id){
        return eelRepo.getOne(id);
    }

    //UPDATE ENTRY AND EXIT
    public void updateEntryExit(EntryExitLog entryExitLog, int id){

        eelRepo.save(entryExitLog);
    }

    //DELETE ENTRY AND EXIT
    public void deleteEntryExit(int id){

        eelRepo.deleteById(id);
    }

    //FIND ENTRY AND EXITS LOG BY EMPLOYEE
    public List<EntryExitLog> findByEmployee(String name){
        return eelRepo.findByEmployee(name);
    }

    //FIND ENTRY AND EXIT BY COMPANY
    public List<EntryExitLog> findByCompany(String companyName){
        return eelRepo.findByCompany(companyName);
    }

}
