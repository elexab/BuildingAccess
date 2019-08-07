package com.company.BuildingAccess.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;
import java.util.Random;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="employee")
public class Employee {
    //CREATE COLUMNS FOR THE TABLE
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer employeeId;
    @NotEmpty
    @Length(max=50)
    private String name;
    @NotEmpty
    @Length(max=50)
    private String title;
    @NotEmpty
    @Length(max=50)
    private String companyName;
    @NotEmpty
    @Length(max=50)
    private String hireDate;
    @NotEmpty
    @Length(max=50)
    private String startTime;
    @NotEmpty
    @Length(max=50)
    private String endTime;

    Random rand = new Random();

//    //THIS IS USED TO LINKED TWO DIFFERENT TABLES TOGETHER
//    //BY THE FOREIGN KEY, COMPANY ID
    @ManyToOne(fetch=FetchType.EAGER)//USE THIS TO LINKED TWO TABLES
    @JoinColumn(name="companyid", updatable = false, insertable = false)//FOREIGN KEY
    private Company company;

    @ManyToOne(fetch=FetchType.EAGER)//USE THIS TO LINKED TWO TABLES
    @JoinColumn(name="logid", updatable = false, insertable = false)//FOREIGN KEY
    private EntryExitLog log;

    //GETTERS AND SETTERS
    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return companyName;
    }

    public void setCompany(String companyName) {

        this.companyName = companyName;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    //THIS IS A METHOD USED TO COMPARE THE INFORMATION
    //IN SEVERAL DIFFERENT TABLES TO MAKE SURE IT IS EXACTLY
    //THE SAME
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(employeeId, employee.employeeId) &&
                Objects.equals(name, employee.name) &&
                Objects.equals(title, employee.title) &&
                Objects.equals(companyName, employee.companyName) &&
                Objects.equals(hireDate, employee.hireDate) &&
                Objects.equals(startTime, employee.startTime) &&
                Objects.equals(endTime, employee.endTime) &&
                Objects.equals(company, employee.company);
    }
    //USED WITH OBJECT EQUALS
    @Override
    public int hashCode() {
        return Objects.hash(employeeId, name, title, companyName, hireDate, startTime, endTime, company);
    }
    //THIS IS USED TO MAKE THE PRINT LOOK NEAT AND CORRECT
    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", companyName='" + companyName + '\'' +
                ", hireDate='" + hireDate + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", company=" + company +
                '}';
    }
}
