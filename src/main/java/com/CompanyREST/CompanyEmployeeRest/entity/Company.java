package com.CompanyREST.CompanyEmployeeRest.entity;

import jakarta.persistence.*;
import org.apache.catalina.LifecycleState;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "industry")
    private String industry;

    @Column(name = "location")
    private String location;

    @OneToMany(mappedBy = "company",cascade = CascadeType.ALL)
    private List<Employee> employees = new ArrayList<>(); // stavit cu da inicijalizira praznu listu jer ako to ne stavin response nece radit zbog stream kojeg koristin

    public Company() {
    }

    public Company(String name, String industry, String location) {
        this.name = name;
        this.industry = industry;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    // metoda za dodat employeea
    public void addEmployee(Employee employee){
        if (employees == null){
            employees = new ArrayList<>();
        }
        employees.add(employee);
    }

    // metoda za remove employeea
    public void removeEmployee(Employee employee){

        employees.remove(employee);
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", industry='" + industry + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
