package com.cognizant.orm_learn.service;

import com.cognizant.orm_learn.entity.Employee;
import com.cognizant.orm_learn.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllPermanentEmployees() {
        return employeeRepository.getAllPermanentEmployees();
    }

    public List<Employee> getAllPermanentEmployeesWithFetch() {
        return employeeRepository.getAllPermanentEmployeesWithFetch();
    }

    public Double getAverageSalary(int deptId) {
        return employeeRepository.getAverageSalary(deptId);
    }

    public List<Employee> getAllEmployeesNative() {
        return employeeRepository.getAllEmployeesNative();
    }
}