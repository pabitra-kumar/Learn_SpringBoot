package com.example.Learn_SpringBoot.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.Learn_SpringBoot.dto.EmployeeDTO;
import com.example.Learn_SpringBoot.entities.EmployeeEntity;
import com.example.Learn_SpringBoot.repositories.EmployeeRepository;

@Service
public class EmployeeService {

    final EmployeeRepository employeeRepository;
    final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public EmployeeDTO getEmployeeById(Long id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();

        return modelMapper.map(employeeEntity, EmployeeDTO.class);
    }

    public EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO, EmployeeEntity.class);

        return modelMapper.map(employeeRepository.save(employeeEntity), EmployeeDTO.class);
    }
}
