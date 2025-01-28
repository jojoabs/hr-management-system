package com.example.hr_management_system.service;

import com.example.hr_management_system.dto.EmployeeDTO;
import com.example.hr_management_system.exception.ResourceNotFoundException;
import com.example.hr_management_system.model.Employee;
import com.example.hr_management_system.repository.EmployeeRepository;
import com.example.hr_management_system.util.EmployeeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(EmployeeConverter::toDTO)
                .collect(Collectors.toList());
    }

    public EmployeeDTO getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Funcionário não encontrado com ID: " + id));
        return EmployeeConverter.toDTO(employee);
    }

    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = EmployeeConverter.toEntity(employeeDTO);
        return EmployeeConverter.toDTO(employeeRepository.save(employee));
    }

    public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Funcionário não encontrado com ID: " + id));

        existingEmployee.setName(employeeDTO.getName());
        existingEmployee.setDepartment(employeeDTO.getDepartment());
        existingEmployee.setPosition(employeeDTO.getPosition());
        existingEmployee.setSalary(employeeDTO.getSalary());

        return EmployeeConverter.toDTO(employeeRepository.save(existingEmployee));
    }

    public Page<EmployeeDTO> getEmployeesWithPagination(Pageable pageable) {
        return employeeRepository.findAll(pageable)
                .map(EmployeeConverter::toDTO);
    }

    public void deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Funcionário não encontrado com ID: " + id));
        employeeRepository.delete(employee);
    }
}