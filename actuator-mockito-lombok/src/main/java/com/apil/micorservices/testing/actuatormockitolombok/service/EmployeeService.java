package com.apil.micorservices.testing.actuatormockitolombok.service;


import com.apil.micorservices.testing.actuatormockitolombok.model.Employee;


public interface EmployeeService {

    Employee getEmployee(int Id);
    Employee addEmployee(Employee employee);

}
