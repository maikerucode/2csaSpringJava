package com.csa.samplefullstack.Controller;

import com.csa.samplefullstack.Entity.Employee;
import com.csa.samplefullstack.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @GetMapping("/employees/Id")
    public Employee getEmployeeFromId(@PathVariable Long Id){
        return employeeRepository.findById(Id).get();
    }
    @PutMapping("/employees")
    public Employee putEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @DeleteMapping("/employees/{Id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable Long Id) {
        employeeRepository.deleteById(Id);
        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }
}
