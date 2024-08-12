package com.spring_boot_demo.crudDemo.rest;

import com.spring_boot_demo.crudDemo.dao.EmployeeDAO;
import com.spring_boot_demo.crudDemo.entity.Employee;
import com.spring_boot_demo.crudDemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;

    // constructor injection
    @Autowired
    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    // return employee list
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    // find employee by ID
    @GetMapping("/employees/{employeeID}")
    public Employee findByID(@PathVariable int employeeID){
        return employeeService.findByID(employeeID);
    }

    // enter new entry inside the database
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        // incase if user passes an ID into JSON over Postman then set ID to 0
        // it will force to save a new item instead of update
        employee.setId(0);

        return employeeService.save(employee);
    }

    // update an entry inside the database table
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    // delete an entry from database table
    @DeleteMapping("/employees/{employeesID}")
    public String deleteEmployee(@PathVariable int ID){
        employeeService.deleteByID(ID);
        return "Data with ID = "+ID+" has been deleted succesfully.";
    }
}
