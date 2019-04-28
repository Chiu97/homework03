package com.bjtu.homework03.repository;

import com.bjtu.homework03.entity.Employee;
import com.bjtu.homework03.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
