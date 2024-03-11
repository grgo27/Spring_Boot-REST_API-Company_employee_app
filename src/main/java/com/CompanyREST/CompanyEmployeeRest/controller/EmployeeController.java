package com.CompanyREST.CompanyEmployeeRest.controller;

import com.CompanyREST.CompanyEmployeeRest.dto.EmployeeDto;
import com.CompanyREST.CompanyEmployeeRest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Endpoint for adding/saving employee
    @PostMapping
    public ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto employeeDto){

        return new ResponseEntity<>(employeeService.saveEmployee(employeeDto), HttpStatus.CREATED); // nisan assigna u nikakvu varijablu return od saveEmployee nego san direktno pozva ode
    }

    // Endpoint for getting all employees
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        List<EmployeeDto> employeeDtos = employeeService.getAllEmployees();
        return ResponseEntity.ok(employeeDtos);
    }

    // Endpoint for getting single employee
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id){
        EmployeeDto employeeDto = employeeService.getEmployeeByid(id);
        return ResponseEntity.ok(employeeDto);
    }

    // Endpoint for deleting  employee
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>("Employee with id: " + id + " deleted sucessfully",HttpStatus.OK);
    }

    // Endpoint for editing employee
    @PutMapping("/{id}/edit")
    public ResponseEntity<EmployeeDto> editEmployee(@PathVariable Long id, @RequestBody EmployeeDto employeeDto){
        return new ResponseEntity<>(employeeService.editEmployee(id,employeeDto),HttpStatus.OK);
    }

}
