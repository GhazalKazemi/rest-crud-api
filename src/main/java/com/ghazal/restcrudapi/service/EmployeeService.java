package com.ghazal.restcrudapi.service;

import com.ghazal.restcrudapi.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
}
