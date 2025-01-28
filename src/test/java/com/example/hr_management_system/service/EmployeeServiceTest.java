package com.example.hr_management_system.service;

import com.example.hr_management_system.dto.EmployeeDTO;
import com.example.hr_management_system.model.Employee;
import com.example.hr_management_system.repository.EmployeeRepository;
import com.example.hr_management_system.util.EmployeeConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateEmployee() {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setName("João Teste");
        employeeDTO.setDepartment("TI");
        employeeDTO.setPosition("Dev");
        employeeDTO.setSalary(7000.0);

        Employee savedEmployee = EmployeeConverter.toEntity(employeeDTO);
        when(employeeRepository.save(any(Employee.class))).thenReturn(savedEmployee);

        EmployeeDTO result = employeeService.createEmployee(employeeDTO);

        assertNotNull(result);
        assertEquals(employeeDTO.getName(), result.getName());
        assertEquals(employeeDTO.getDepartment(), result.getDepartment());
        assertEquals(employeeDTO.getPosition(), result.getPosition());
        assertEquals(employeeDTO.getSalary(), result.getSalary());
    }
}