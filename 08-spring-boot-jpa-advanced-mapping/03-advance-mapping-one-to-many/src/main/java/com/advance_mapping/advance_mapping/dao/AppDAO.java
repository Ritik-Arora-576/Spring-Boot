package com.advance_mapping.advance_mapping.dao;

import com.advance_mapping.advance_mapping.entity.Course;
import com.advance_mapping.advance_mapping.entity.Instructor;
import com.advance_mapping.advance_mapping.entity.InstructorDetail;

import java.util.List;

public interface AppDAO {
    void save(Instructor theInstructor);
    Instructor findInstructorByID(int theID);
    void deleteInstructorByID(int ID);
    InstructorDetail findInstructorDetailByID(int theID);
    void deleteInstructorDetailByID(int ID);
    List<Course> findCoursesByInstructorID(int ID);
    Instructor findInstructorByJoinFetch(int ID);
    void update(Instructor instructor);
    void update(Course tempCourse);
    Course findCourseByID(int ID);
}
