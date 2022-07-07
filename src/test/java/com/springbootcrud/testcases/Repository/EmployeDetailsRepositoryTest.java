package com.springbootcrud.testcases.Repository;

import com.springbootcrud.testcases.Entity.EmployeeDetails;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class EmployeDetailsRepositoryTest {

    @Autowired
    private EmployeDetailsRepository employeDetailsRepository;

    @Autowired
    private TestEntityManager testEntityManager;
    @BeforeEach
    void setUp() {
        EmployeeDetails employeeDetails=EmployeeDetails.builder().employeeid(100L).salary(19000L).empname("testing").designation("Software Engineer").build();
        testEntityManager.persistAndFlush(employeeDetails);
    }

    @Test
    void EmpRepoTest(){
        EmployeeDetails employeeDetails=employeDetailsRepository.findBySalary(19000L).get(1);
        assertEquals(19000L,employeeDetails.getEmployeeid());
    }
}