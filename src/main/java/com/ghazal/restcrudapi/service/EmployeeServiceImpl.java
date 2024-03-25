package com.ghazal.restcrudapi.service;

import com.ghazal.restcrudapi.dao.EmployeeDAO;
import com.ghazal.restcrudapi.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee save(Employee employee) {
        return employeeDAO.save(employee);
    }

    @Override
    public Employee findById(Long id) {
        return employeeDAO.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        employeeDAO.deleteById(id);
    }
}
