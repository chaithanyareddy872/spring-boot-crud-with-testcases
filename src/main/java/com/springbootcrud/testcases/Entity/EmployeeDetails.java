package com.springbootcrud.testcases.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long employeeid;

    @Column
    private String empname;

    @Column
    private String designation;

    @Column
    private Long salary;

}
