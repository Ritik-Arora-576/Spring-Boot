package com.advance_mapping.advance_mapping.dao;

import com.advance_mapping.advance_mapping.entity.Instructor;
import com.advance_mapping.advance_mapping.entity.InstructorDetail;

public interface AppDAO {
    void save(Instructor theInstructor);
    Instructor findInstructorByID(int theID);
    void deleteInstructorByID(int ID);
    InstructorDetail findInstructorDetailByID(int theID);
    void deleteInstructorDetailByID(int ID);
}
