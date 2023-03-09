package com.jpa_prac.employee.controller;

import com.jpa_prac.employee.dto.EmployeeDTO;
import com.jpa_prac.employee.dto.response.EmployeeSrchResDTO;
import com.jpa_prac.employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("/api/v1/employees/all")
    public EmployeeSrchResDTO retrieveAllEmployee() {
        return employeeService.retrieveAllEmployee();
    }

    @GetMapping("/api/v1/employees/{employeeId}")
    public EmployeeDTO retrieveEmployeeById(@PathVariable("employeeId") long employeeId) {
        return employeeService.retrieveEmployeeById(employeeId);
    }

}
