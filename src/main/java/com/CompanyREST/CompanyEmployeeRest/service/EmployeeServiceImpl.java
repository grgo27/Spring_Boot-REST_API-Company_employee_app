package com.CompanyREST.CompanyEmployeeRest.service;

import com.CompanyREST.CompanyEmployeeRest.dto.EmployeeDto;
import com.CompanyREST.CompanyEmployeeRest.entity.Employee;
import com.CompanyREST.CompanyEmployeeRest.exception.EmployeeNotFoundException;
import com.CompanyREST.CompanyEmployeeRest.mapper.EmployeeMapper;
import com.CompanyREST.CompanyEmployeeRest.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeDto> employeeDtos = employees.stream().map(EmployeeMapper::mapToEmployeeDto).collect(Collectors.toList());
        return employeeDtos;
    }

    @Override
    public EmployeeDto getEmployeeByid(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public EmployeeDto editEmployee(Long id, EmployeeDto employeeDto) {
        Employee employeeToEdit = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
        if (employeeDto.getName() != null) {
            employeeToEdit.setName(employeeDto.getName());
        }
        if (employeeDto.getPosition() != null) {
            employeeToEdit.setPosition(employeeDto.getPosition());
        }
        if (employeeDto.getSalary() != null) {
            employeeToEdit.setSalary(employeeDto.getSalary());
        }
        Employee savedEmployee = employeeRepository.save(employeeToEdit);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
        employeeRepository.delete(employee);
    }
}
