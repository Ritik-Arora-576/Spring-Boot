package com.spring_boot.postman.rest;

import com.spring_boot.postman.entity.student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api") // It defines how HTTP requests handled by the controller methods
public class DemoRestController {

    private ArrayList<student> theStudents;

    @PostConstruct
    public void loadData(){
        theStudents = new ArrayList<>();

        theStudents.add(new student("Ritik", "Arora"));
        theStudents.add(new student("Mansi", "Agarwal"));
        theStudents.add(new student("Yash", "Gupta"));
    }

    @GetMapping("/test")
    public String sayHello(){
        return "Hello World..";
    }

    // This will create the API using Spring Rest and Jackson
    // In spring Jackson project is used for data binding.
    // Data Binding: It is a process of converting JSON object into JAVA POJO (Plain Old Java Objects) and vice versa.
    @GetMapping("/students")
    public ArrayList<student> fetchStudents(){
        return theStudents;
    }

    @GetMapping("/students/{studentID}")
    // @PathVariable is used to transfer the value of studentID variable into {studentID} endpoint
    public student fetchStudentByID(@PathVariable int studentID){
        // handling exception if student is not found
        if(studentID<0 || studentID>=theStudents.size()){
            throw new StudentNotFoundException("Student ID not found "+studentID);
        }

        return theStudents.get(studentID);
    }
}
