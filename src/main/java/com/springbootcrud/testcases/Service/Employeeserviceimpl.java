package com.springbootcrud.testcases.Service;

import com.springbootcrud.testcases.Entity.EmployeeDetails;
import com.springbootcrud.testcases.Exceptions.EmpNotFoundException;
import com.springbootcrud.testcases.Repository.EmployeDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Employeeserviceimpl implements Employeeservice{

    @Autowired
    EmployeDetailsRepository employeDetailsRepository;
    @Override
    public List<EmployeeDetails> finallemps() {
        return employeDetailsRepository.findAll();
    }

    @Override
    public EmployeeDetails findempbyid(Long id) {
        return employeDetailsRepository.findById(id).orElseThrow(()->new EmpNotFoundException("user not found"));
    }

    @Override
    public EmployeeDetails saveemp(EmployeeDetails employeeDetails) {
        return employeDetailsRepository.save(employeeDetails);
 }

    @Override
    public ResponseEntity<EmployeeDetails> updateemp(EmployeeDetails employeeDetails, Long id) {
        EmployeeDetails employeeDetails1=employeDetailsRepository.findById(id).orElseThrow(()->new EmpNotFoundException(("employee not found")));
        employeeDetails1.setEmpname(employeeDetails.getEmpname());
        employeeDetails1.setDesignation(employeeDetails.getDesignation());
        employeeDetails1.setSalary(employeeDetails.getSalary());
        return ResponseEntity.ok().body(employeDetailsRepository.save(employeeDetails1));
    }

    @Override
    public String deleteemp(Long id) {
        employeDetailsRepository.findById(id).orElseThrow(()->new EmpNotFoundException("user not found"));
        employeDetailsRepository.deleteById(id);
        return "deleted successfully";
    }
}
