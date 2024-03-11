package com.CompanyREST.CompanyEmployeeRest.service;

import com.CompanyREST.CompanyEmployeeRest.dto.CompanyDto;
import com.CompanyREST.CompanyEmployeeRest.dto.EmployeeDto;

import java.util.List;

public interface CompanyService {

    CompanyDto saveCompany(CompanyDto companyDto);

    List<CompanyDto> getAllCompanies();

    CompanyDto getCompanyByid(Long id);

    CompanyDto editCompany(Long id, CompanyDto companyDto);

    void deleteCompany(Long id);

    CompanyDto addEmployee(Long companyId, Long employeeId);

    CompanyDto removeEmployee(Long companyId, Long employeeId);
}
