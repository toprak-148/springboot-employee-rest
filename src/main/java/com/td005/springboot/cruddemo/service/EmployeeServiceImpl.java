package com.td005.springboot.cruddemo.service;

import com.td005.springboot.cruddemo.dao.EmployeeDao;
import com.td005.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements  EmployeeService{


    private EmployeeDao employeeDao;

    public EmployeeServiceImpl()
    {

    }

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao)
    {
        this.employeeDao = employeeDao;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public Employee findById(int employeeId)
    {
        return employeeDao.findById(employeeId);
    }
}
