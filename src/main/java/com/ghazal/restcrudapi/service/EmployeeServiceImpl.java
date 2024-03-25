package com.ghazal.restcrudapi.service;

import com.ghazal.restcrudapi.dao.EmployeeDAO;
import com.ghazal.restcrudapi.entity.Employee;
import com.ghazal.restcrudapi.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee findById(Long id) {
        Optional<Employee> employeeById = employeeRepository.findById(id);
        Employee employee = null;
        if(employeeById.isPresent()){
            employee = employeeById.get();
        }else {
            throw new RuntimeException("Employee with the id " + id + " was not found");
        }
        return employee;
    }

    @Override
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }
}
