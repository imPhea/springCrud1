package com.app.demo.controller;

import com.app.demo.exception.NotFoundException;
import com.app.demo.model.Employee;
import com.app.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController implements Serializable {
    @Autowired
    private EmployeeRepository employeeRepository;

    // read
    @GetMapping
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    // find by id
    @GetMapping("/{id}")
    public ResponseEntity<Employee> findOne(@PathVariable Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Employee not exist by id= "+id));
        return ResponseEntity.ok(employee);
    }

    // create
    @PostMapping
    public Employee create(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    // update
    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(@PathVariable Long id, @RequestBody Employee employeeDetail) {
        // check employee exist or not
        Employee updateEmployee = employeeRepository.findById(id).
                orElseThrow(()->new NotFoundException("Employee id="+id+" not exist."));
        updateEmployee.setFirstName(employeeDetail.getFirstName());
        updateEmployee.setLastName(employeeDetail.getLastName());
        updateEmployee.setGmailId(employeeDetail.getGmailId());

        employeeRepository.save(updateEmployee);
        return ResponseEntity.ok(updateEmployee);
    }

    // delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> delete(@PathVariable Long id) {
        // check exist or not
        Employee deleteEmployee = employeeRepository.findById(id).orElseThrow(()->new NotFoundException("Employee id="+id+" not exist."));
        employeeRepository.delete(deleteEmployee);
        return ResponseEntity.ok(deleteEmployee);
    }

    /* or
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
        // check exist or not
        Employee deleteEmployee = employeeRepository.findById(id).orElseThrow(()->new NotFoundException("Employee id="+id+" not exist."));
        employeeRepository.delete(deleteEmployee);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } */
}
