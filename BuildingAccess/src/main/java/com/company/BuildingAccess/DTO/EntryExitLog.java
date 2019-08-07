package com.company.BuildingAccess.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="log")
public class EntryExitLog {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer logId;
    private Integer employeeId;
    @NotEmpty
    private String entryTime;
    @NotEmpty
    private String exitTime;



    //ONE ENTRY EXIT LOG TO MANY EMPLOYEES
    //LINKS TO THE EMPLOYEE SET
    //ALLOWS AN ENTRY EXIT LOG TO HAVE MANY EMPLOYEES
    @OneToMany(mappedBy="log", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JsonIgnore
    private Set<Employee> employees;

    //GETTERS AND SETTERS
    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEntry() {
        return entryTime;
    }

    public void setEntry(String entryTime) {
        this.entryTime = entryTime;
    }

    public String getExit() {
        return exitTime;
    }

    public void setExit(String exitTime) {
        this.exitTime = exitTime;
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
        EntryExitLog that = (EntryExitLog) o;
        return Objects.equals(logId, that.logId) &&
                Objects.equals(employeeId, that.employeeId) &&
                Objects.equals(entryTime, that.entryTime) &&
                Objects.equals(exitTime, that.exitTime) &&
                Objects.equals(employees, that.employees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(logId, employeeId, entryTime, exitTime,  employees);
    }

    @Override
    public String toString() {
        return "EntryExitLog{" +
                "logId=" + logId +
                ", employeeId=" + employeeId +
                ", entry=" + entryTime +
                ", exits=" + exitTime +
                ", employees=" + employees +
                '}';
    }
}
