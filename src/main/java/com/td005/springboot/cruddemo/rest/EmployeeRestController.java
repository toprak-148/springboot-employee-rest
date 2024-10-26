package com.td005.springboot.cruddemo.rest;

import com.td005.springboot.cruddemo.dao.EmployeeDao;
import com.td005.springboot.cruddemo.entity.Employee;
import com.td005.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId)
    {
        Employee employee = employeeService.findById(employeeId);
        if (employee == null)
        {
            throw new RuntimeException("Employee id not found : " + employeeId);
        }
        return employee;
    }
    //add mapping for POST /employees - add new employees
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee)
    {
        // also just in case they pass an id in JSON... set id to 0
        //this is to force a save of new item... instead of update

        theEmployee.setId(0);
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;

    }


    //Add maping for PUT /employees - update existing employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee)
    {
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }


    //add mapping for DELETE /employees/{emloyeeId} - delete employee
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId)
    {
        Employee tempEmployee = employeeService.findById(employeeId);
        //throw excepiton if null
        if(tempEmployee == null)
        {
            throw new RuntimeException("Employee id not found " + employeeId);
        }
        employeeService.deleteById(employeeId);
        return "Delete employee id  : " + employeeId;
    }


}
