package com.CompanyREST.CompanyEmployeeRest.repository;

import com.CompanyREST.CompanyEmployeeRest.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
