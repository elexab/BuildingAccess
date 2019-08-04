package com.company.BuildingAccess.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="entryExitLog")
public class EntryExitLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer logId;
    @NotNull
    private Integer entry;
    @NotNull
    private Integer exit;
    @NotNull
    private Integer time;

    //ONE ENTRY EXIT LOG TO MANY EMPLOYEES
    //LINKS TO THE EMPLOYEE SET
    //ALLOWS AN ENTRY EXIT LOG TO HAVE MANY EMPLOYEES
    @OneToMany(mappedBy="entryExitLog", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JsonIgnore
    private Set<Employee> employees;

    //GETTERS AND SETTERS
    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public Integer getEntry() {
        return entry;
    }

    public void setEntry(Integer entry) {
        this.entry = entry;
    }

    public Integer getExit() {
        return exit;
    }

    public void setExit(Integer exit) {
        this.exit = exit;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
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
                Objects.equals(entry, that.entry) &&
                Objects.equals(exit, that.exit) &&
                Objects.equals(time, that.time) &&
                Objects.equals(employees, that.employees);
    }
    //USED WITH OBJECT EQUALS
    @Override
    public int hashCode() {
        return Objects.hash(logId, entry, exit, time, employees);
    }

    //THIS IS USED TO MAKE THE PRINT LOOK NEAT AND CORRECT
    @Override
    public String toString() {
        return "EntryExitLog{" +
                "logId=" + logId +
                ", entry=" + entry +
                ", exit=" + exit +
                ", time=" + time +
                ", employees=" + employees +
                '}';
    }
}
