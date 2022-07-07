package com.springbootcrud.testcases.Repository;

import com.springbootcrud.testcases.Entity.EmployeeDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface EmployeDetailsRepository extends JpaRepository<EmployeeDetails,Long> {
    List<EmployeeDetails> findBySalary(long l);
}
