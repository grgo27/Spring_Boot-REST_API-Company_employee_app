package com.CompanyREST.CompanyEmployeeRest.exception;

import java.text.MessageFormat;

public class CompanyNotFoundException extends RuntimeException{
    public CompanyNotFoundException(Long id) {
        super(MessageFormat.format("Company with id: {0} not found",id));
    }
}
