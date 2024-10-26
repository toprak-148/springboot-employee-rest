package com.td005.springboot.cruddemo.dao;

import com.td005.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> findAll();

    Employee findById(int employeeId);

    Employee save(Employee employee);
    void delete(int employeeId);
}
