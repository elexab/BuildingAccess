package com.company.BuildingAccess.Controller;


import com.company.BuildingAccess.DTO.Company;
import com.company.BuildingAccess.Service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CompanyController {
    //LINK TO SERVICE LAYER
    @Autowired
    private CompanyService service;

    //LIST ALL APIs

    //CRUD OPERATIONS

    //CREATE, POST
    @RequestMapping(value = "/company", method = RequestMethod.POST)
    public Company addCompany(@RequestBody @Valid Company company){
        return service.addCompany(company);
    }

    //READ, GET
    @RequestMapping(value="/company", method = RequestMethod.GET)
    public List<Company> getAllCompanies(){

        return service.getAllCompanies();
    }

    //READ, GET BY ID
    @RequestMapping(value = "/company/{id}", method = RequestMethod.GET)
    public Company getCompanyById(@PathVariable int id){

        return service.getCompanyById(id);
    }

    //UPDATE
    @RequestMapping(value = "/company/{id}", method = RequestMethod.PUT)
    public void updateCompany(@RequestBody @Valid Company company, @PathVariable int id){
        service.updateCompany(company,id);
    }

    //DELETE
    @RequestMapping(value = "/company/{id}", method = RequestMethod.DELETE)
    public void deleteCompany(@RequestBody @Valid Company company, @PathVariable int id){
        service.deleteCompany(id);
    }

    //FIND COMPANY BY NAME
    @RequestMapping(value = "/companyByName/{companyName}", method = RequestMethod.GET)
    public List<Company> getCompanyByName(@PathVariable String companyName){
        return service.findByCompanyName(companyName);
    }

    //FIND COMPANY BY FLOOR
    @RequestMapping(value = "/companyByFloor/{floor}", method = RequestMethod.GET)
    public List<Company> getCompanyByFloor(@PathVariable Integer floor){
        return service.findByFloor(floor);
    }

    //METHOD FOR EMPLOYEE ACCESS
    @RequestMapping(value = "/companyAccess/{floor}", method = RequestMethod.GET)
    public boolean getCompanyAccess(boolean access, String companyName, Integer floor, String title){
        access = false;
        //SWITCH STATEMENTS
        switch (companyName){
            case "Carter Transportation":
                if(floor == 1){
                    access = true;
                }
                break;
            case "Tyla's Law Firm":
                if(floor == 2){
                    access = true;
                }
                break;
            case "Teagan's Flower Shop":
                if(floor == 3){
                    access = true;
                }
                break;
            case "Pinterest":
                if(floor == 4){
                    access = true;
                }
                break;
            case "Zara":
                if(floor == 5){
                    access = true;
                }
            case "Sephora":
                if(floor == 6){
                    boolean conferenceRoomAccess = false;
                    boolean serverRoomAccess = false;
                    access = true;
                    if(title.equals("Manager")){
                        conferenceRoomAccess = true;
                    }
                    if(title.equals("Database Admin")){
                        serverRoomAccess = true;
                    }
                }
            case "Nordstrom":
                if(floor == 7 && floor == 8){
                    access = true;
                }
        }
        return service.access(access, companyName, floor, title);
    }

}

