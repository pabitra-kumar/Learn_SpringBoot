package com.example.Learn_SpringBoot.controllers;

import java.util.*;

import org.springframework.web.bind.annotation.DeleteMapping;

// import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Learn_SpringBoot.dto.EmployeeDTO;
import com.example.Learn_SpringBoot.services.EmployeeService;

// import jakarta.websocket.server.PathParam;

// Operations to be performed by the controller
// GET /employees
// POST /employees
// DELETE /employees/{id}

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable("id") Long employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }

    @GetMapping
    public List<EmployeeDTO> getEmployee() {
        return employeeService.getEmployees();
    }

    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.createNewEmployee(employeeDTO);
    }

    @DeleteMapping(path = "/{id}")
    public boolean deleteEmployeeById(@PathVariable("id") Long employeeId) {
        return employeeService.deleteEmployeeById(employeeId);
    }

}
