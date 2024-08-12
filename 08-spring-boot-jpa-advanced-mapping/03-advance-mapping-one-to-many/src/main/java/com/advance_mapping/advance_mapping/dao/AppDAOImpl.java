package com.advance_mapping.advance_mapping.dao;

import com.advance_mapping.advance_mapping.entity.Course;
import com.advance_mapping.advance_mapping.entity.Instructor;
import com.advance_mapping.advance_mapping.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        List<Course> courses = theInstructor.getCourses();

        // break the association of all the courses for related instructor
        for(Course course: courses){
            course.setInstructor(null);
        }

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

    @Override
    public List<Course> findCoursesByInstructorID(int ID){
        TypedQuery<Course> query = entityManager.createQuery(
                "from Course where instructor.id = :data",
                Course.class
        );
        query.setParameter("data", ID);

        List<Course> courses = query.getResultList();
        return courses;
    }

    @Override
    @Transactional
    public void update(Instructor instructor){
        entityManager.merge(instructor);
    }

    @Override
    @Transactional
    public void update(Course course){
        entityManager.merge(course);
    }

    @Override
    public Course findCourseByID(int ID){
        return entityManager.find(Course.class, ID);
    }

    @Override
    public Instructor findInstructorByJoinFetch(int ID) {
        TypedQuery<Instructor> query = entityManager.createQuery("select i from Instructor i "
                + "JOIN FETCH i.courses "
                + "where i.id= :data", Instructor.class);
        query.setParameter("data", ID);

        Instructor instructor = query.getSingleResult();
        System.out.println(instructor.getCourses());
        return instructor;
    }
}
