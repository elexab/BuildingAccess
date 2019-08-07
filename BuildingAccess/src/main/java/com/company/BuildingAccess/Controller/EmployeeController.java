package com.company.BuildingAccess.Controller;

import com.company.BuildingAccess.DTO.Employee;
import com.company.BuildingAccess.Service.EmployeeService;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EmployeeController {
    //LINK TO SERVICE LAYER
    @Autowired
    private EmployeeService service;



    //LIST ALL APIs

    //CRUD OPERATIONS

    //CREATE, POST
    @RequestMapping(value="/employee", method = RequestMethod.POST)
    public Employee addEmployee(@RequestBody @Valid Employee employee){
        return service.addEmployee(employee);
    }

    //READ, GET
    @RequestMapping(value="/employee", method = RequestMethod.GET)
    public List<Employee> getAllEmployees(){
        return service.getAllEmployees();
    }

    //READ, GET BY ID
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    public Employee getEmployeeById(@PathVariable int id){
        return service.getEmployeeById(id);
    }

    //UPDATE
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.PUT)
    public void updateEmployee(@RequestBody @Valid Employee employee, @PathVariable int id){
        service.updateEmployeeById(employee,id);
    }

    //DELETE
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
    public void deleteEmployee(@RequestBody @Valid Employee employee, @PathVariable int id){
        service.deleteEmployeeById(id);
    }

    //FIND EMPLOYEE BY NAME, GET
    @RequestMapping(value = "/employeeByName/{name}", method = RequestMethod.GET)
    public List<Employee> getEmployeeByName(@PathVariable String name){
        return service.findByName(name);
    }

    //FIND EMPLOYEE BY TITLE, GET
    @RequestMapping(value = "/employeeByTitle/{title}", method = RequestMethod.GET)
    public List<Employee> getEmployeeByTitle(@PathVariable String title){
        return service.findByTitle(title);
    }

    //FIND EMPLOYEE BY HIRE DATE, GET
    @RequestMapping(value = "/employeeByHireDate/{hireDate}", method = RequestMethod.GET)
    public List<Employee> getEmployeeByHireDate(@PathVariable String hireDate){
        return service.findByHireDate(hireDate);
    }

    //FIND EMPLOYEE BY COMPANY, GET
    @RequestMapping(value = "/employeeByCompany/{companyName}", method = RequestMethod.GET)
    public List<Employee> getEmployeeByCompany(@PathVariable String companyName){
        return service.findByCompany(companyName);
    }

}
