package com.ghazal.restcrudapi.dao;

import com.ghazal.restcrudapi.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
}
