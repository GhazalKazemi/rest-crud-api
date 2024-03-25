package com.ghazal.restcrudapi.dao;

import com.ghazal.restcrudapi.entity.Employee;
import com.ghazal.restcrudapi.service.EmployeeService;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

    Employee findById(Long id);

    Employee save(Employee employee);

    void deleteById(Long id);
}
