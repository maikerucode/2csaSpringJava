package com.csa.samplefullstack.Controller;

import com.csa.samplefullstack.Entity.Employee;
import com.csa.samplefullstack.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class EmployeeController {

    @Autowired // spring dependency injection
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    @PostMapping("/employees")
    public Employee postEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

}
