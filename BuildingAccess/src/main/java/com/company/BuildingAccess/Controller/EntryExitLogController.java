package com.company.BuildingAccess.Controller;


import com.company.BuildingAccess.DTO.EntryExitLog;
import com.company.BuildingAccess.Service.EntryExitLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EntryExitLogController {
    //LINK TO SERVICE LAYER
    @Autowired
    private EntryExitLogService service;

    //LIST ALL APIs

    //CRUD OPERATIONS

    //CREATE, POST
    @RequestMapping(value = "/entryExitLog", method = RequestMethod.POST)
    public EntryExitLog addEntryExitLog(@RequestBody @Valid EntryExitLog entryExitLog){
        return service.addEntryExitLog(entryExitLog);
    }

    //READ, GET
    @RequestMapping(value="/entryExitLog", method = RequestMethod.GET)
    public List<EntryExitLog> getAllEntryExit(){

        return service.getAllEntryExit();
    }

    //READ, GET BY ID
    @RequestMapping(value = "/entryExitLog/{id}", method = RequestMethod.GET)
    public EntryExitLog getCompanyById(@PathVariable int id){

        return service.getEntryExitById(id);
    }

    //UPDATE
    @RequestMapping(value = "/entryExitLog/{id}", method = RequestMethod.PUT)
    public void updateCompany(@RequestBody @Valid EntryExitLog entryExitLog, @PathVariable int id){
        service.updateEntryExit(entryExitLog,id);
    }

    //DELETE
    @RequestMapping(value = "/entryExitLog/{id}", method = RequestMethod.DELETE)
    public void deleteEntryExit(@RequestBody @Valid EntryExitLog entryExitLog, @PathVariable int id){
        service.deleteEntryExit(id);
    }

    //FIND ENTRY EXIT LOF BY EMPLOYEE
    @RequestMapping(value = "/entryExitLogByEmployee/{name}", method = RequestMethod.GET)
    public List<EntryExitLog> getEntryExitByEmployee(@PathVariable String name){
        return service.findByEmployee(name);
    }

    //FIND ENTRY EXIT LOG BY COMPANY
    @RequestMapping(value = "/entryExitLogByCompany/{companyName}", method = RequestMethod.GET)
    public List<EntryExitLog> getCompanyByFloor(@PathVariable String companyName){
        return service.findByCompany(companyName);
    }
}
