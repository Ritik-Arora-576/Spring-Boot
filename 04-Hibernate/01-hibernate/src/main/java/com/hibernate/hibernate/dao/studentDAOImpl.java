package com.hibernate.hibernate.dao;

import com.hibernate.hibernate.entity.student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*
 @Repository annotation is used to indicate that a particular class defines a data repository.
 It is typically applied to DAO (Data Access Object) classes that act as a mechanism to encapsulate
 storage, retrieval, and search behavior for entities within an application's data source, such as a database.
 */
@Repository
public class studentDAOImpl implements studentDAO{
    // define the feild Entity manager
    // It is responsible for managing entities within a persistent storage
    private EntityManager entityManager;

    // constructor injection
    @Autowired
    public studentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional // apply to that methods which are performing updates to database
    public void save(student theStudent){
        entityManager.persist(theStudent);
    }

    @Override
    public student findByID(Integer id){
        return entityManager.find(student.class, id);
    }

    @Override
    public List<student> findAll(){
        // create query
        TypedQuery<student> theQuery = entityManager.createQuery("FROM student order by lastName", student.class);

        // return the result
        return theQuery.getResultList();
    }

    @Override
    public List<student> findByLastName(String theLastName) {
        // create query
        TypedQuery<student> theQuery = entityManager.createQuery("FROM student WHERE lastName=:theData", student.class);

        // set the query parameter
        // set the 'theData' parameter to 'theLastName'
        theQuery.setParameter("theData", theLastName);

        // return the result
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        // find student by ID
        student myStudent = entityManager.find(student.class, id);

        // deleting the student from database
        entityManager.remove(myStudent);
    }
}
