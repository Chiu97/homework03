package com.bjtu.homework03.repository;

import com.bjtu.homework03.entity.Employee;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
//    @Query("select * from employees")
////    List<Employee> findEmployeesWithLimit(Pageable pageable);

}
