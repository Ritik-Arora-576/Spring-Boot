package com.hibernate.hibernate;

import com.hibernate.hibernate.dao.studentDAO;
import com.hibernate.hibernate.entity.student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class HibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateApplication.class, args);
	}

	// below function executed after spring bean has been loaded
	@Bean
	public CommandLineRunner commandLineRunner(studentDAO studentDAO){
		// lambda function
		return runner->{
//			createStudent(studentDAO);
//			readStudent(studentDAO);
//			queryForStudents(studentDAO);
//			queryForStudentsByLastName(studentDAO);
//			updateStudent(studentDAO);
			deleteStudentByID(studentDAO);
		};
	}

	private void deleteStudentByID(studentDAO studentDAO) {
		// find student by ID
		// deleting a student with ID=3
		int ID = 3;

		// deleting from database
		studentDAO.delete(ID);
	}

	private void updateStudent(studentDAO studentDAO) {
		// find student by ID
		student myStudent = studentDAO.findByID(2);

		// set last name to 'Gupta'
		myStudent.setLastName("Gupta");

		// update the table
		studentDAO.update(myStudent);

		// display the result
		System.out.println("Updated student is "+myStudent);
	}

	private void queryForStudentsByLastName(studentDAO studentDAO) {
		// fetch the data
		List<student> theStudents = studentDAO.findByLastName("Arora");

		// display the results
		for(student student:theStudents){
			System.out.println(student);
		}
	}

	private void queryForStudents(studentDAO studentDAO) {
		// fetch the data
		List<student> theStudents = studentDAO.findAll();

		// display the results
		for(student student:theStudents){
			System.out.println(student);
		}
	}

	private void readStudent(studentDAO studentDAO) {
		// create student object
		student tempStudent = new student("Mansi", "Aggarwal", "m.aggarwal656@gmail.com");

		// save an object into database
		studentDAO.save(tempStudent);

		// find the student by an ID
		int ID = tempStudent.getId();
		student myStudent = studentDAO.findByID(ID);

		// Display the information
		System.out.println("Found the student "+myStudent);
	}

	private void createStudent(studentDAO studentDAO) {
		// create the student object
		System.out.println("Creating a new student object...");
		student tempStudent = new student("Ritik", "Arora", "Ritikarora656@gmail.com");

		// save the student object
		System.out.println("Saving the student object into database..");
		studentDAO.save(tempStudent);

		// display the ID of the saved student
		System.out.println("Display the ID of student: " + tempStudent.getId());
	}
}
