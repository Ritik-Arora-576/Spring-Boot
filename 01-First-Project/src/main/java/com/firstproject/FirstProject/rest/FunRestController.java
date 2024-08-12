package com.firstproject.FirstProject.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RestController;

// '@RestController' is an annotation. Everything which starts which '@' is considered as annotation.
@RestController
public class FunRestController {
    // injecting the properties from application.properties
    @Value("${employee.name}")
    public String empName;

    @Value("${organization.name}")
    public String org;

    @GetMapping("/getInfo")
    public String getInfo(){
        return empName + " is working in "+org;
    }

    // expose "/" that return 'Hello World"
    @GetMapping("/")
    public String sayHello(){
        return "Hello World";
    }

    // adding a new endpoint
    @GetMapping("/workout")
    public String goingWorkout(){
        return "I'm working out";
    }
}
