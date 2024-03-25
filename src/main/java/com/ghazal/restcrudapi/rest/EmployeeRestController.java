package com.ghazal.restcrudapi.rest;

import com.ghazal.restcrudapi.dao.EmployeeDAO;
import com.ghazal.restcrudapi.entity.Employee;
import com.ghazal.restcrudapi.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {

    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping
    public List<Employee> findAll(){
        return employeeService.findAll();
    }
    @GetMapping("/{employeeId}")
    public Employee findById(@PathVariable Long employeeId){
        Employee employeeById = employeeService.findById(employeeId);
        if(employeeById == null){
            throw new RuntimeException("Employee with the Id: " + employeeId + " not found.");
        }
        return employeeById;
    }
    @PostMapping
    public Employee save( @RequestBody Employee employee){
        employee.setId(0L); // it'll be saved as a new entry otherwise it'll be overwritten (update)
        return employeeService.save(employee);
    }
    @PutMapping
    public Employee update(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @DeleteMapping("/{employeeId}")
    public String deleteById(@PathVariable Long employeeId){
        Employee employeeById = employeeService.findById(employeeId);
        if(employeeById == null){
            throw new RuntimeException("Employee with id: " + employeeId + " does not exist.");
        }
        employeeService.deleteById(employeeId);
        return "Deleted Employee by Id: " + employeeId;
    }

}
