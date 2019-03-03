package com.apil.micorservices.testing.actuatormockitolombok.service;

import com.apil.micorservices.testing.actuatormockitolombok.model.Employee;
import com.apil.micorservices.testing.actuatormockitolombok.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee getEmployee(int Id) {
        return employeeRepository.findById(Id).get();
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}
