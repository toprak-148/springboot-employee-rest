package com.td005.springboot.cruddemo.dao;

import com.td005.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDao {

    //define field for entityManager
    private EntityManager entityManager;


    // set up constructor injection

    public EmployeeDAOJpaImpl()
    {

    }

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }


    @Override
    public List<Employee> findAll() {
        //create a query

        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee" , Employee.class);
        //execute query
        List<Employee> results = theQuery.getResultList();
        //return the results
        return results;
    }

    @Override
    public Employee findById(int employeeId)
    {
        //get employee
        Employee employee = entityManager.find(Employee.class,employeeId);

        //return employee
        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        //save Employee
        //Enity objesinin kimliğine göre bir güncelleme gerekecektir.id == 0 ise save işlemi yapılır değilse bir güncelleme işlemine tabii tutulu
        Employee dbEmployee = entityManager.merge(employee);


        return dbEmployee;
    }

    @Override
    public void delete(int employeeId) {

        //find emloyee by Id
        Employee delEmployee = entityManager.find(Employee.class,employeeId);

        //remove employee
        entityManager.remove(delEmployee);
    }
}
