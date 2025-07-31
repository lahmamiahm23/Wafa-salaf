package com.example.wafaapp.repositories;

import com.example.wafaapp.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeDao extends JpaRepository<Employee, Long> {
    Optional<Employee> findByEmail(String email);
}
