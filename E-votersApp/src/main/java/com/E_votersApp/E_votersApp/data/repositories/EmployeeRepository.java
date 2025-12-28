package com.E_votersApp.E_votersApp.data.repositories;

import com.E_votersApp.E_votersApp.data.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
