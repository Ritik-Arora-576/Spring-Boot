package com.spring_boot_demo.crudDemo.dao;

import com.spring_boot_demo.crudDemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImp implements EmployeeDAO{
    // define entity manager
    private EntityManager entityManager;

    // dependency injection
    @Autowired
    public EmployeeDAOImp(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public List<Employee> findAll(){
        // create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("FROM Employee", Employee.class);

        // fetch the list
        List<Employee> employees = theQuery.getResultList();

        // return employees list
        return employees;
    }

    @Override
    public Employee findByID(int ID) {
        // find student by ID
        Employee employee = entityManager.find(Employee.class, ID);

        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        return entityManager.merge(employee);
    }

    @Override
    public void deleteByID(int ID) {
        Employee employee = entityManager.find(Employee.class, ID);
        entityManager.remove(employee);
    }
}
