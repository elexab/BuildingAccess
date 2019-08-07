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
    @RequestMapping(value = "/companyByName/{name}", method = RequestMethod.GET)
    public List<Company> getCompanyByName(@PathVariable String name){
        return service.findByName(name);
    }

    //FIND COMPANY BY FLOOR
    @RequestMapping(value = "/companyByFloor/{floor}", method = RequestMethod.GET)
    public List<Company> getCompanyByFloor(@PathVariable Integer floor){
        return service.findByFloor(floor);
    }
//
////    //METHOD FOR EMPLOYEE ACCESS
    @RequestMapping(value = "/companyAccess/{companyName}/{floor}", method = RequestMethod.GET)
    public boolean getCompanyAccess(  @PathVariable String companyName, @PathVariable Integer floor,
                                    @PathVariable String title){
            return service.companyAccess(companyName, floor, title);

    }

}

