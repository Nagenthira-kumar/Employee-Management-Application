package com.NagenthiraKumar.Employeemanager.repo;

import com.NagenthiraKumar.Employeemanager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {

   //void deleteEmployeeById(Long id);
   Optional<Employee> findEmployeeById(Long id);


   void deleteById(Long id);
}
