package com.jason.employeesystemapi.controller;

import com.jason.employeesystemapi.model.Employee;
import com.jason.employeesystemapi.services.EmployeeService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;

  public EmployeeController(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  @PostMapping("/employees")
  public Employee createEmployee(@RequestBody Employee employee) {
    return employeeService.createEmployee(employee);
  }

  @GetMapping("/employees")
  public List<Employee> getAllEmployees() {
    return employeeService.getAllEmployees();
  }

  @DeleteMapping("/employees/{id}")
  public ResponseEntity<Map<String, Boolean>> deleteEmployee(
    @PathVariable Long id
  ) {
    boolean deleted = false;
    deleted = employeeService.deleteEmployee(id);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", deleted);
    return ResponseEntity.ok(response);
  }

  @GetMapping("/employees/{id}")
  public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
    Employee employee = null;
    employee = employeeService.getEmployeeById(id);
    return ResponseEntity.ok(employee);
  }

  @GetMapping("/employees/{id}")
  ResponseEntity<Employee> updateEmployee(
    @PathVariable long id,
    @RequestBody Employee employee
  ) {
    employee = employeeService.updateEmployee(id, employee);
    return ResponseEntity.ok(employee);
  }
}
