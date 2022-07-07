package com.springbootcrud.testcases.Controller;

import com.springbootcrud.testcases.Entity.EmployeeDetails;
import com.springbootcrud.testcases.Service.Employeeservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpController {

    @Autowired
    Employeeservice employeeservice;

    @GetMapping("/employees")
    List<EmployeeDetails> getallemp(){
        return employeeservice.finallemps();
    }

    @GetMapping("/employee/{id}")
    EmployeeDetails getempbyid(@PathVariable("id") Long id){
        return employeeservice.findempbyid(id);
    }

    @PostMapping("/employee")
    EmployeeDetails saveemp(@RequestBody EmployeeDetails employeeDetails){
        return employeeservice.saveemp(employeeDetails);
    }

    @PutMapping("/employee/{id}")
    ResponseEntity<EmployeeDetails> updateemp(@RequestBody EmployeeDetails employeeDetails, @PathVariable("id") Long id){
        return employeeservice.updateemp(employeeDetails,id);
    }

    @DeleteMapping("/employee/{id}")
    String deleteemp(@PathVariable("id") Long id){
        return employeeservice.deleteemp(id);
    }
}
