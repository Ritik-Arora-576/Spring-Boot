package com.spring_boot_demo.crudDemo.dao;

import com.spring_boot_demo.crudDemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
    Employee findByID(int ID);
    Employee save(Employee employee);
    void deleteByID(int ID);
}
