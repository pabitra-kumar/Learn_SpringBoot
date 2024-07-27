package com.example.Learn_SpringBoot.services;

import org.springframework.stereotype.Service;

import com.example.Learn_SpringBoot.dto.EmployeeDTO;
import com.example.Learn_SpringBoot.entities.EmployeeEntity;
import com.example.Learn_SpringBoot.repositories.EmployeeRepository;

@Service
public class EmployeeService {

    final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeDTO getEmployeeById(Long id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();

        return new EmployeeDTO(employeeEntity.getId(), employeeEntity.getName(), employeeEntity.getDateOfJoining(),
                employeeEntity.isActive());
    }
}
