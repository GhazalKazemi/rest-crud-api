package com.ghazal.restcrudapi.repository;

import com.ghazal.restcrudapi.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
