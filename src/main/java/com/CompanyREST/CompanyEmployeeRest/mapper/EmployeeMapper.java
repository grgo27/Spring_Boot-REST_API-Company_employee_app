package com.CompanyREST.CompanyEmployeeRest.mapper;

import com.CompanyREST.CompanyEmployeeRest.dto.EmployeeDto;
import com.CompanyREST.CompanyEmployeeRest.entity.Employee;

import java.util.Objects;

public class EmployeeMapper {

    public static Employee mapToEmployee(EmployeeDto employeeDto){
        Employee employee = new Employee();
        employee.setName(employeeDto.getName());
        employee.setPosition(employeeDto.getPosition());
        employee.setSalary(employeeDto.getSalary());
        return employee;
    }

    public static EmployeeDto mapToEmployeeDto(Employee employee){
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setName(employee.getName());
        employeeDto.setPosition(employee.getPosition());
        employeeDto.setSalary(employee.getSalary());
        if (Objects.nonNull(employee.getCompany())){ // isto sto i employee.getCompany != null
            employeeDto.setPlainCompanyDto(CompanyMapper.mapToPlainCompanyDto(employee.getCompany()));
        }
        return employeeDto;
    }
}
