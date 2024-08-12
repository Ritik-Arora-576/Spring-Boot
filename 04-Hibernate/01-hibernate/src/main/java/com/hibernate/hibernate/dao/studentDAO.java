package com.hibernate.hibernate.dao;

import com.hibernate.hibernate.entity.student;

import java.util.List;

/*
Data Access Object: It is a way of organizing code to handle the communication
                    between your program and database. It helps to keep your
                    code clean and separate the logic for interacting with data
                    from rest of the application.

1. It abstracts and encapsulates the details of how data is saved, retrieved, update or delete in database.
2. It centralized all database related code withim dedicated DAO class. It means that the root of the application
doesn't need to scatter database operation throughout its codebase, instead it intracts with DAO methods.
 */

public interface studentDAO {
    void save(student theStudent);
    student findByID(Integer id);
    List<student> findAll();
    List<student> findByLastName(String theLastName);
    void update(student theStudent);
    void delete(Integer id);
}
