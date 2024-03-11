package com.CompanyREST.CompanyEmployeeRest.mapper;

import com.CompanyREST.CompanyEmployeeRest.dto.CompanyDto;
import com.CompanyREST.CompanyEmployeeRest.dto.PlainCompanyDto;
import com.CompanyREST.CompanyEmployeeRest.entity.Company;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class CompanyMapper {

    public static Company mapToCompany(CompanyDto companyDto){
        Company company = new Company();
        company.setName(companyDto.getName());
        company.setIndustry(companyDto.getIndustry());
        company.setLocation(companyDto.getLocation());
        return company;
    }

    public static CompanyDto mapToCompanyDto(Company company){
        CompanyDto companyDto = new CompanyDto();
        companyDto.setId(company.getId());
        companyDto.setName(company.getName());
        companyDto.setIndustry(company.getIndustry());
        companyDto.setLocation(company.getLocation());
        companyDto.setEmployeeDtos(company.getEmployees().stream().map(EmployeeMapper::mapToEmployeeDto).collect(Collectors.toList())); // dohvatit listu employeesa od kompanije i tu listu employeesa konvertirat u listu employaa dtosa

        return companyDto;
    }

    public static PlainCompanyDto mapToPlainCompanyDto(Company company){
        PlainCompanyDto plainCompanyDto = new PlainCompanyDto();
        plainCompanyDto.setId(company.getId());
        plainCompanyDto.setName(company.getName());
        plainCompanyDto.setIndustry(company.getIndustry());
        plainCompanyDto.setLocation(company.getLocation());
        return plainCompanyDto;
    }
}
