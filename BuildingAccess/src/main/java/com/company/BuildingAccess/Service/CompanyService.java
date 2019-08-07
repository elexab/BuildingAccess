package com.company.BuildingAccess.Service;

import com.company.BuildingAccess.DAO.CompanyRepository;
import com.company.BuildingAccess.DAO.EmployeeRepository;
import com.company.BuildingAccess.DAO.EntryExitLogRepository;
import com.company.BuildingAccess.DTO.Company;
import com.company.BuildingAccess.DTO.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CompanyService{
    //LINK TO REPOSITORY
    @Autowired
    private EntryExitLogRepository eelRepo;

    @Autowired
    private CompanyRepository compRepo;

    @Autowired
    private EmployeeRepository empRepo;

    //METHODS

    //ADD COMPANIES
    public Company addCompany(Company company){
        compRepo.save(company);
        return company;
    }

    //GET ALL COMPANIES
    public List<Company> getAllCompanies(){
        return compRepo.findAll();
    }

    //GET COMPANY BY ID
    public Company getCompanyById(int id){
        return compRepo.getOne(id);
    }

    //UPDATE COMPANY
    public void updateCompany(Company company, int id){
        //UPDATES COMPANY'S FLOOR
        Company tempCompany = compRepo.getOne(id);
        tempCompany.setFloor(company.getFloor());
        compRepo.save(tempCompany);
    }

    //DELETE COMPANY
    public void deleteCompany(int id){
        compRepo.deleteById(id);
    }

    //FIND COMPANY BY NAME
    public List<Company> findByName(String name){
        return compRepo.findByName(name);
    }

    //FIND COMPANY BY FLOOR
    public List<Company> findByFloor(Integer floor){
        return compRepo.findByFloor(floor);
    }

//    //METHOD FOR EMPLOYEE ACCESS
    public boolean companyAccess( String companyName, Integer floor, String title) {
        boolean access = false;
//        Employee employee = empRepo.getOne(id);
//        title = employee.getTitle();
        //SWITCH STATEMENTS
        switch (companyName){
            case "Carter Transportation":
                                            if(floor == 1){
                                                access = true;
                                                System.out.println("You have access to the 1st floor only.");
                                            }
                                            break;
            case "Urban Outfitters":
                                            if(floor == 2){
                                                access = true;
                                                System.out.println("You have access to the 2nd floor only.");
                                            }
                                            break;
            case "Nike":
                                            if(floor == 3){
                                                access = true;
                                                System.out.println("You have access to the 3rd floor only.");
                                            }
                                            break;
            case "Pinterest":
                                            if(floor == 4){
                                                access = true;
                                                System.out.println("You have access to the 4th floor only.");
                                            }
                                            break;
            case "Zara":
                                            if(floor == 5){
                                                access = true;
                                                System.out.println("You have access to the 5th floor only.");
                                            }
            case "Sephora":
                                            if(floor == 6){
                                            boolean conferenceRoomAccess = false;
                                            boolean serverRoomAccess = false;
                                                access = true;
                                                System.out.println("You have access to the 6th floor only, but not the" +
                                                        "conference room or server room.");
                                                if(title.equals("Manager")){
                                                    conferenceRoomAccess = true;
                                                    System.out.println("You have access to the 6th floor only, and the" +
                                                            "conference room, but not the server room.");
                                                }
                                                if(title.equals("Database Admin")){
                                                    serverRoomAccess = true;
                                                    System.out.println("You have access to the 6th floor only, and the" +
                                                            "server room, but not the conference room.");
                                                }
                                            }
            case "Nordstrom":
                                            if(floor == 7 && floor == 8){
                                                access = true;
                                                System.out.println("You have access to the 7th and 8th floor only.");
                                            }
        }
                        return access;

    }



}
