/*
 * You can use the following import statements
 *
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 */

// Write your code here
package com.example.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeJpaService;

@RestController
public class EmployeeController {
    @Autowired
    public EmployeeJpaService employeeJpaService;

    @GetMapping("/employees")
    public ArrayList<Employee> getEmployeesList() {
        return employeeJpaService.getEmployees();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId) {
        return employeeJpaService.getEmployeeById(employeeId);
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeJpaService.addEmployee(employee);
    }

    @PutMapping("/employees/{employeeId}")
    public Employee updaEmployee(@PathVariable int employeeId, @RequestBody Employee employee) {
        return employeeJpaService.updateEmployee(employeeId, employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public void deleteEmployee(@PathVariable int employeeId) {
        employeeJpaService.deleteEmployee(employeeId);
    }

}