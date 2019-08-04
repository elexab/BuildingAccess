package com.company.BuildingAccess.Service;

import com.company.BuildingAccess.DAO.CompanyRepository;
import com.company.BuildingAccess.DTO.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CompanyService{
    //LINK TO REPOSITORY
    @Autowired
    private CompanyRepository compRepo;

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
        compRepo.save(company);
    }

    //DELETE COMPANY
    public void deleteCompany(int id){
        compRepo.deleteById(id);
    }

    //FIND COMPANY BY NAME
    public List<Company> findByCompanyName(String name){
        return compRepo.findByCompanyName(name);
    }

    //FIND COMPANY BY FLOOR
    public List<Company> findByFloor(Integer floor){
        return compRepo.findByFloor(floor);
    }

    //METHOD FOR EMPLOYEE ACCESS
    public boolean access(boolean access, String companyName, Integer floor, String title) {
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
                        return access;
    }



}
