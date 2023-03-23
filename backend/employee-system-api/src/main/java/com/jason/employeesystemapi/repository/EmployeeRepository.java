package com.jason.employeesystemapi.repository;

import com.jason.employeesystemapi.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository
  extends JpaRepository<EmployeeEntity, Long> {}
