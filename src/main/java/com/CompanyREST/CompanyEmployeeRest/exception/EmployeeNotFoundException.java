package com.CompanyREST.CompanyEmployeeRest.exception;

import java.text.MessageFormat;

public class EmployeeNotFoundException extends RuntimeException{

    public EmployeeNotFoundException(Long id) {
        super(MessageFormat.format("Employee with id: {0} not found", id));
    }
}
