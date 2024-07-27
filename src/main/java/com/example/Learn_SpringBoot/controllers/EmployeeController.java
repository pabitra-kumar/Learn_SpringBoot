package com.example.Learn_SpringBoot.controllers;

// import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Learn_SpringBoot.dto.EmployeeDTO;
import com.example.Learn_SpringBoot.services.EmployeeService;

import jakarta.websocket.server.PathParam;

// Operations to be performed by the controller
// GET /employees
// POST /employees
// DELETE /employees/{id}

@RestController
public class EmployeeController {

    final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/employees/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable("id") Long employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }

    @GetMapping(path = "/employees")
    public String getEmployee(@PathParam("sortBy") String sortBy, @PathParam("limit") String limit) {
        return "Hello " + sortBy + " " + limit;
    }

    @PostMapping(path = "/employees")
    public String createNewEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return "Hello ";
    }

}
