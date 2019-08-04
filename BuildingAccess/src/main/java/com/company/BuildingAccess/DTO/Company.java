package com.company.BuildingAccess.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.Length;

import javax.annotation.Generated;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer companyId;
    @NotEmpty
    @Length(max=50)
    private String name;
    private boolean access;
    @NotNull
    private Integer floor;
    private boolean promotion;
    private boolean demotion;

    //ONE COMPANY TO MANY EMPLOYEES
    //LINKS TO THE EMPLOYEE SET
    //ALLOWS A COMPANY TO HAVE MANY EMPLOYEES
    @OneToMany(mappedBy="company", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JsonIgnore
    private Set<Employee> employees;

    //GETTERS AND SETTERS
    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAccess() {
        return access;
    }

    public void setAccess(boolean access) {
        this.access = access;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public boolean isPromotion() {
        return promotion;
    }

    public void setPromotion(boolean promotion) {
        this.promotion = promotion;
    }

    public boolean isDemotion() {
        return demotion;
    }

    public void setDemotion(boolean demotion) {
        this.demotion = demotion;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
    //THIS IS A METHOD CREATE TO COMPARE THE INFORMATION
    //IN SEVERAL DIFFERENT TABLES TO MAKE SURE IT IS EXACTLY
    //THE SAME
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return access == company.access &&
                promotion == company.promotion &&
                demotion == company.demotion &&
                Objects.equals(companyId, company.companyId) &&
                Objects.equals(name, company.name) &&
                Objects.equals(floor, company.floor) &&
                Objects.equals(employees, company.employees);
    }
    //USED WITH OBJECT EQUALS
    @Override
    public int hashCode() {
        return Objects.hash(companyId, name, access, floor, promotion, demotion, employees);
    }
    //THIS IS USED TO MAKE THE PRINT LOOK NEAT AND CORRECT
    @Override
    public String toString() {
        return "Company{" +
                "companyId=" + companyId +
                ", name='" + name + '\'' +
                ", access=" + access +
                ", floor=" + floor +
                ", promotion=" + promotion +
                ", demotion=" + demotion +
                ", employees=" + employees +
                '}';
    }
}
