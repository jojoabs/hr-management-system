package com.example.hr_management_system.util;

import com.example.hr_management_system.dto.EmployeeDTO;
import com.example.hr_management_system.model.Employee;

public class EmployeeConverter {

    public static Employee toEntity(EmployeeDTO dto) {
        Employee employee = new Employee();
        employee.setId(dto.getId()); // Incluindo o ID para garantir persistência correta
        employee.setName(dto.getName());
        employee.setDepartment(dto.getDepartment());
        employee.setPosition(dto.getPosition());
        employee.setSalary(dto.getSalary());
        return employee;
    }

    public static EmployeeDTO toDTO(Employee employee) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(employee.getId()); // Garantindo que o ID seja transferido para o DTO
        dto.setName(employee.getName());
        dto.setDepartment(employee.getDepartment());
        dto.setPosition(employee.getPosition());
        dto.setSalary(employee.getSalary());
        return dto;
    }
}
