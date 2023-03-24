package com.jason.employeesystemapi.services;

import com.jason.employeesystemapi.model.Employee;
import java.util.List;

public interface EmployeeService {
  Employee createEmployee(Employee employee);

  List<Employee> getAllEmployees();

boolean deleteEmployee(Long id);

Employee getEmployeeById(Long id);
}
