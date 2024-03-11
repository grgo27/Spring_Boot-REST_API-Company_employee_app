package com.CompanyREST.CompanyEmployeeRest.repository;

import com.CompanyREST.CompanyEmployeeRest.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
