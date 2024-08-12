package com.advance_mapping.advance_mapping.dao;

import com.advance_mapping.advance_mapping.entity.Instructor;
import com.advance_mapping.advance_mapping.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AppDAOImpl implements AppDAO{
    // define field for Entity Manager
    private EntityManager entityManager;

    // inject the entity manager using constructor injection
    @Autowired
    public AppDAOImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
    }

    @Override
    public Instructor findInstructorByID(int ID){
        return entityManager.find(Instructor.class, ID);
    }

    @Override
    @Transactional
    public void deleteInstructorByID(int ID){
        Instructor theInstructor = entityManager.find(Instructor.class, ID);
        entityManager.remove(theInstructor);
    }

    @Override
    public InstructorDetail findInstructorDetailByID(int ID){
        return entityManager.find(InstructorDetail.class, ID);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailByID(int ID){
        InstructorDetail theInstructorDetail = entityManager.find(InstructorDetail.class, ID);

        // If we wanted to remove the Instructor Detail but not the associated instructor then we have to break bi-directional link
        theInstructorDetail.getInstructor().setInstructorDetail(null);

        entityManager.remove(theInstructorDetail);
    }
}
