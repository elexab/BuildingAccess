package com.company.BuildingAccess.Service;

import com.company.BuildingAccess.DAO.EmployeeRepository;
import com.company.BuildingAccess.DTO.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class EmployeeService {
    //LINK TO REPOSITORY
    @Autowired
    private EmployeeRepository expRepo;
    //RANDOM STATEMENT
    Random rand = new Random();


    //METHODS

    //ADDS EMPLOYEES
    public Employee addEmployee(Employee employee){
        expRepo.save(employee);
        return employee;

    }

    //GET ALL EMPLOYEES
    public List<Employee> getAllEmployees(){
        return  expRepo.findAll();
    }

    //GET EMPLOYEES BY ID
    public Employee getEmployeeById(int id){
        return expRepo.getOne(id);
    }

    //RANDOMLY ASSIGN A COMPANY TO AN EMPLOYEE
//    public Employee getCompany(String company){
//        //ASSIGNS A RANDOM COMPANY TO AN EMPLOYEE
//        return expRepo..get(rand.nextInt(company.size()));
//    }


    //UPDATE EMPLOYEE
    public void updateEmployeeById(Employee employee, int id){
        expRepo.save(employee);
    }

    //DELETE EMPLOYEE
    public void deleteEmployeeById(int id){
        expRepo.deleteById(id);
    }

    //FIND EMPLOYEE BY NAME
    public List<Employee> findByName(String name){
        return findByName(name);
    }

    //FIND EMPLOYEE BY JOB TITLE
    public List<Employee> findByTitle(String title){
        return findByTitle(title);
    }

    //FIND EMPLOYEE BY HIRE DATE
    public List<Employee> findByHireDate(String hireDate){
        return findByHireDate(hireDate);
    }

    //
}
