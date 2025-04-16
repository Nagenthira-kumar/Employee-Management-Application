package com.NagenthiraKumar.Employeemanager.service;

import com.NagenthiraKumar.Employeemanager.exception.UserNotFoundException;
import com.NagenthiraKumar.Employeemanager.model.Employee;
import com.NagenthiraKumar.Employeemanager.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;


    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }


    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployee(){

        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepo.save(employee);
    }

    public Employee findEmployeeById(Long id){
        return employeeRepo.findEmployeeById(id).
                orElseThrow(() -> new UserNotFoundException("User by id "+id+"Not found"));
    }

    public void deleteEmployee(Long id){
        employeeRepo.deleteById(id);
    }
}
