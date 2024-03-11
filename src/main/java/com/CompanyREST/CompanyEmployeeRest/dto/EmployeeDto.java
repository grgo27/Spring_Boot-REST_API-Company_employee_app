package com.CompanyREST.CompanyEmployeeRest.dto;



import java.math.BigDecimal;

public class EmployeeDto {

    private Long id;

    private String name;

    private String position;

    private BigDecimal salary;

    private PlainCompanyDto plainCompanyDto;

    public EmployeeDto() {
    }

    public EmployeeDto(String name, String position, BigDecimal salary) {
        this.name = name;
        this.position = position;
        this.salary = salary;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public PlainCompanyDto getPlainCompanyDto() {
        return plainCompanyDto;
    }

    public void setPlainCompanyDto(PlainCompanyDto plainCompanyDto) {
        this.plainCompanyDto = plainCompanyDto;
    }
}
