package com.td005.springboot.cruddemo.rest;

import com.td005.springboot.cruddemo.dao.EmployeeDao;
import com.td005.springboot.cruddemo.entity.Employee;
import com.td005.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    // quick and dirty : inject employee dao ( use constructor injection
    private EmployeeService employeeService;

    public EmployeeRestController()
    {

    }

    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService)
    {
        this.employeeService = theEmployeeService;
    }


    //expose /employees and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll()
    {
        return employeeService.findAll();
    }





}
