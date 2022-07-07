package com.springbootcrud.testcases.Service;

import com.springbootcrud.testcases.Entity.EmployeeDetails;
import com.springbootcrud.testcases.Repository.EmployeDetailsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeserviceimplTest {

    @MockBean
    EmployeDetailsRepository employeDetailsRepository;

    @BeforeEach
    void setUp() {
        EmployeeDetails empdetails= EmployeeDetails.builder().employeeid(100L).empname("chaitanya").designation("Full stack Engineer").salary(19000L).build();
        Mockito.when(employeDetailsRepository.findById(100L)).thenReturn(Optional.ofNullable(empdetails));
    }

    @Test
    void findempbyid() {
        Optional<EmployeeDetails> employeeDetails2=employeDetailsRepository.findById(100L);
        assertEquals(100L,employeeDetails2.get().getEmployeeid());
    }
}