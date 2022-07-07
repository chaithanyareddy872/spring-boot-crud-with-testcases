package com.springbootcrud.testcases.Service;

import com.springbootcrud.testcases.Entity.EmployeeDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Employeeservice {

    List<EmployeeDetails> finallemps();
    EmployeeDetails findempbyid(Long id);
    EmployeeDetails saveemp(EmployeeDetails employeeDetails);
    ResponseEntity<EmployeeDetails> updateemp(EmployeeDetails employeeDetails, Long id);
    String deleteemp(Long id);
}
