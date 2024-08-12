package com.spring_boot_demo.crudDemo.service;

import com.spring_boot_demo.crudDemo.dao.EmployeeDAO;
import com.spring_boot_demo.crudDemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService{
    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImp(EmployeeDAO employeeDAO){
        this.employeeDAO = employeeDAO;
    }

    public List<Employee> findAll(){
        return employeeDAO.findAll();
    }

    @Override
    public Employee findByID(int ID) {
        return employeeDAO.findByID(ID);
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        return employeeDAO.save(employee);
    }

    @Override
    @Transactional
    public void deleteByID(int ID) {
        employeeDAO.deleteByID(ID);
    }
}
