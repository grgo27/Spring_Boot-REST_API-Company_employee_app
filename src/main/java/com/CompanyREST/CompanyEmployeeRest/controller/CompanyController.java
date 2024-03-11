package com.CompanyREST.CompanyEmployeeRest.controller;

import com.CompanyREST.CompanyEmployeeRest.dto.CompanyDto;
import com.CompanyREST.CompanyEmployeeRest.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    private CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    // Endpoint for adding/saving company
    @PostMapping
    public ResponseEntity<CompanyDto> addCompany(@RequestBody CompanyDto companyDto){
        return new ResponseEntity<>(companyService.saveCompany(companyDto), HttpStatus.CREATED);
    }

    // Endpoint for getting all companies
    @GetMapping
    public ResponseEntity<List<CompanyDto>> getAllCompanies(){
        List<CompanyDto> companyDtos = companyService.getAllCompanies();
        return ResponseEntity.ok(companyDtos);
    }

    // Endpoint for getting single company
    @GetMapping("/{id}")
    public ResponseEntity<CompanyDto> getSingleCompany(@PathVariable Long id){
        CompanyDto companyDto = companyService.getCompanyByid(id);
        return ResponseEntity.ok(companyDto);
    }

    // Endpoint for deleting company
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id){
        companyService.deleteCompany(id);
        return new ResponseEntity<>("Company with id: " + id + " sucessfully deleted.",HttpStatus.OK);
    }

    // Endpoint for editing company
    @PutMapping("/{id}/edit")
    public ResponseEntity<CompanyDto> editCompany(@PathVariable Long id, @RequestBody CompanyDto companyDto){
        return new ResponseEntity<>(companyService.editCompany(id,companyDto),HttpStatus.OK);
    }

    // Endpoint for adding employee to company
    @PostMapping("/{companyId}/employee/{employeeId}/add")
    public ResponseEntity<CompanyDto> addEmployeeToCompany(@PathVariable Long companyId, @PathVariable Long employeeId){
        CompanyDto companyDto = companyService.addEmployee(companyId,employeeId);
        return ResponseEntity.ok(companyDto);
    }

    // Endpoint for removing employee from company
    @DeleteMapping("/{companyId}/employee/{employeeId}/remove")
    public ResponseEntity<CompanyDto> removeEmployeeFromCompany(@PathVariable Long companyId, @PathVariable Long employeeId){
        CompanyDto companyDto = companyService.removeEmployee(companyId,employeeId);
        return ResponseEntity.ok(companyDto);
    }



}
