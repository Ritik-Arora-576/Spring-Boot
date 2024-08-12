package com.advance_mapping.advance_mapping.dao;

import com.advance_mapping.advance_mapping.entity.Instructor;

public interface AppDAO {
    void save(Instructor theInstructor);
    Instructor findInstructorByID(int theID);
    void deleteInstructorByID(int ID);
}
