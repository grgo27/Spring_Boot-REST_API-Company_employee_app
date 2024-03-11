package com.CompanyREST.CompanyEmployeeRest.exception;

import java.text.MessageFormat;

public class EmployeeAlreadyAssignedException extends RuntimeException{

    public EmployeeAlreadyAssignedException(Long employeeId, Long companyId){
        super(MessageFormat.format("Employee with id: {0} is already assigned to company with id: {1}!",employeeId, companyId));
    }
}
