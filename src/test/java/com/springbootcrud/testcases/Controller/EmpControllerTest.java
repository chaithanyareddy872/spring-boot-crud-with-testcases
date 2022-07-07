package com.springbootcrud.testcases.Controller;

import com.springbootcrud.testcases.Entity.EmployeeDetails;
import com.springbootcrud.testcases.Service.Employeeserviceimpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

@WebMvcTest(EmpController.class)
@AutoConfigureMockMvc
class EmpControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private Employeeserviceimpl employeeserviceimpl;

    private EmployeeDetails employeeDetails;


    @BeforeEach
    void setUp() {
        employeeDetails=EmployeeDetails.builder().empname("chaitanya").designation("full stack engineer").salary(19000L).build();
    }

    @Test
    void saveemp() throws Exception{
         EmployeeDetails employeeDetails1=EmployeeDetails.builder().empname("chaitanya").designation("full stack engineer").salary(19000L).build();
        Mockito.when(employeeserviceimpl.saveemp(employeeDetails1)).thenReturn(employeeDetails);
        mockMvc.perform(post("/employee").contentType(MediaType.APPLICATION_JSON).content("{\n" +
                "    \"empname\":\"chaitanya reddy\",\n" +
                "    \"designation\":\"Full stack Engineer\",\n" +
                "    \"salary\":\"19000\"\n" +
                "}")).andExpect(status().isOk());

    }
    @Test
    void testget() throws Exception {
        Mockito.when(employeeserviceimpl.findempbyid(1L)).thenReturn(employeeDetails);
        mockMvc.perform(get("/employee/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.empname").value(employeeDetails.getEmpname()));
    }
}