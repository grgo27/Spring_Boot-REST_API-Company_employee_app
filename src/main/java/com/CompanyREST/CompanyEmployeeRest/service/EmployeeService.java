package com.CompanyREST.CompanyEmployeeRest.service;

import com.CompanyREST.CompanyEmployeeRest.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto getEmployeeByid(Long id);

    EmployeeDto editEmployee(Long id, EmployeeDto employeeDto);

    void deleteEmployee(Long id);
}
