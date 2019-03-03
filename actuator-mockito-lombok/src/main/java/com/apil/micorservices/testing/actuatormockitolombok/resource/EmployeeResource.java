package com.apil.micorservices.testing.actuatormockitolombok.resource;


import com.apil.micorservices.testing.actuatormockitolombok.model.Employee;
import com.apil.micorservices.testing.actuatormockitolombok.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import java.net.URI;

@Component
@RestController
public class EmployeeResource {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<Object> createEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
        return ResponseEntity.created(URI.create("/add")).build();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable int id){
        return employeeService.getEmployee(id);
    }
}
