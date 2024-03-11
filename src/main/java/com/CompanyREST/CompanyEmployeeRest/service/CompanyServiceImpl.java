package com.CompanyREST.CompanyEmployeeRest.service;

import com.CompanyREST.CompanyEmployeeRest.dto.CompanyDto;
import com.CompanyREST.CompanyEmployeeRest.dto.EmployeeDto;
import com.CompanyREST.CompanyEmployeeRest.entity.Company;
import com.CompanyREST.CompanyEmployeeRest.entity.Employee;
import com.CompanyREST.CompanyEmployeeRest.exception.CompanyNotFoundException;
import com.CompanyREST.CompanyEmployeeRest.exception.EmployeeAlreadyAssignedException;
import com.CompanyREST.CompanyEmployeeRest.exception.EmployeeNotFoundException;
import com.CompanyREST.CompanyEmployeeRest.mapper.CompanyMapper;
import com.CompanyREST.CompanyEmployeeRest.repository.CompanyRepository;
import com.CompanyREST.CompanyEmployeeRest.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;
    private EmployeeRepository employeeRepository;

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository, EmployeeRepository employeeRepository) {
        this.companyRepository = companyRepository;
        this.employeeRepository = employeeRepository;
    }


    @Override
    public CompanyDto saveCompany(CompanyDto companyDto) {
        Company company = CompanyMapper.mapToCompany(companyDto);
        Company savedCompany = companyRepository.save(company);
        return CompanyMapper.mapToCompanyDto(savedCompany);
    }

    @Override
    public List<CompanyDto> getAllCompanies() {
        List<Company> companies = companyRepository.findAll();
        List<CompanyDto> companiesDtos = companies.stream().map(CompanyMapper::mapToCompanyDto).collect(Collectors.toList());
        return companiesDtos;
    }

    @Override
    public CompanyDto getCompanyByid(Long id) {
        Company company = companyRepository.findById(id).orElseThrow(() -> new CompanyNotFoundException(id));
        return CompanyMapper.mapToCompanyDto(company);
    }

    @Override
    public CompanyDto editCompany(Long id, CompanyDto companyDto) {
        Company company = companyRepository.findById(id).orElseThrow(() -> new CompanyNotFoundException(id));
        if (companyDto.getName() != null) {
            company.setName(companyDto.getName());
        }
        if (companyDto.getIndustry() != null) {
            company.setIndustry(companyDto.getIndustry());
        }
        if (companyDto.getLocation() != null) {
            company.setLocation(companyDto.getLocation());
        }
        Company savedCompany = companyRepository.save(company);
        return CompanyMapper.mapToCompanyDto(savedCompany);
    }

    @Override
    public void deleteCompany(Long id) {
        Company company = companyRepository.findById(id).orElseThrow(() -> new CompanyNotFoundException(id));
        companyRepository.delete(company);
    }

    @Override
    public CompanyDto addEmployee(Long companyId, Long employeeId) {
        Company company = companyRepository.findById(companyId).orElseThrow(() -> new CompanyNotFoundException(companyId));
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new EmployeeNotFoundException(employeeId));
        if (employee.getCompany() != null){ // provjerit da employee nije vec assignan u neku kompaniju
            throw new EmployeeAlreadyAssignedException(employeeId,employee.getCompany().getId());
        }
        company.addEmployee(employee);
        employee.setCompany(company); // uspostavit bi directional
        Company savedCompany = companyRepository.save(company);
        return CompanyMapper.mapToCompanyDto(savedCompany);
    }

    @Override
    public CompanyDto removeEmployee(Long companyId, Long employeeId) {
        Company company = companyRepository.findById(companyId).orElseThrow(() -> new CompanyNotFoundException(companyId));
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new EmployeeNotFoundException(employeeId));
        company.removeEmployee(employee);
        employee.setCompany(null);
        Company savedCompany = companyRepository.save(company); // spremit ce i employee zbog cascade
        return CompanyMapper.mapToCompanyDto(savedCompany);
    }


}
