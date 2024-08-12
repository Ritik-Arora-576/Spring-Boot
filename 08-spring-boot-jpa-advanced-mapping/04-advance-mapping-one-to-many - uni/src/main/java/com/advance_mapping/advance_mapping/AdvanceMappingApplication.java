package com.advance_mapping.advance_mapping;

import com.advance_mapping.advance_mapping.dao.AppDAO;
import com.advance_mapping.advance_mapping.entity.Course;
import com.advance_mapping.advance_mapping.entity.Instructor;
import com.advance_mapping.advance_mapping.entity.InstructorDetail;
import com.advance_mapping.advance_mapping.entity.Review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AdvanceMappingApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvanceMappingApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner ->{
			createCourseAndReview(appDAO);
		};
	}

	public void createCourseAndReview(AppDAO appDAO){
		Course course = new Course("Java");

		course.addReview(new Review("Lovely Course"));
		course.addReview(new Review("Author is great"));
		course.addReview(new Review("Worthwhile to purchase..."));

		appDAO.save(course);
	}

	public void updateCourseByID(AppDAO appDAO){
		int id = 10;
		Course course = appDAO.findCourseByID(id);
		System.out.println(course);

		course.setTitle("Drawing");
		appDAO.update(course);
	}

	private void updateInstructorWithID(AppDAO appDAO){
		int id = 1;
		Instructor instructor = appDAO.findInstructorByID(1);
		System.out.println("Before Update:"+instructor);
		instructor.setLastName("Arora");
		appDAO.update(instructor);
		System.out.println("After Updation:"+instructor);
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO){
		int ID =1;
		Instructor instructor = appDAO.findInstructorByJoinFetch(ID);
		System.out.println("Instructor: "+instructor);
	}

	private void findCourseWithInstructorID(AppDAO appDAO){
		int ID = 1;
		Instructor instructor = appDAO.findInstructorByID(ID);
		System.out.println("Instructor: " + instructor);

		List<Course> courses = appDAO.findCoursesByInstructorID(ID);

		// associate the object
		instructor.setCourses(courses);
		System.out.println("Courses: " + instructor.getCourses());
	}

	private void findInstructorWithCourses(AppDAO appDAO){
		int ID = 1;
		Instructor tempInstructor = appDAO.findInstructorByID(ID);
		System.out.println("Instructor with ID="+ID+"="+tempInstructor);
		System.out.println("Instructor with ID: "+ID+" has courses "+tempInstructor.getCourses());
	}

	private void createInstructorWithCourses(AppDAO appDAO){
		// create the instructor
		Instructor tempInstructor = new Instructor("Susan", "Patel", "susanPatel@gmail.com");

		// create instructor detail
		InstructorDetail tempInstructorDetail = new InstructorDetail("http://susanPatel/youtube",
				"Painting");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// create the courses
		Course course1 = new Course("Painting");
		Course course2 = new Course("Guitar");

		// add courses to instructor
		tempInstructor.add(course1);
		tempInstructor.add(course2);

		System.out.println("Saving the Instructor");

		appDAO.save(tempInstructor);
	}

	private void deleteInstructorDetail(AppDAO appDAO){
		int ID=1;
		appDAO.deleteInstructorDetailByID(ID);
	}

	private InstructorDetail findInstructorDetail(AppDAO appDAO){
		int ID=1;
		InstructorDetail instructorDetail = appDAO.findInstructorDetailByID(ID);
		System.out.println("Instructor Details: "+instructorDetail);
		return instructorDetail;
	}

	private void deleteInstructor(AppDAO appDAO){
		int ID=1;
		appDAO.deleteInstructorByID(ID);
	}

	private Instructor findInstructor(AppDAO appDAO){
		int ID = 2;
		Instructor theInstructor = appDAO.findInstructorByID(ID);
		System.out.println("Instructor: "+theInstructor);
		return theInstructor;
	}

	private void createInstructor(AppDAO appDAO){
		/*
		// create the instructor
		Instructor tempInstructor = new Instructor("Chad", "Darby", "darby@luv2code.com");

		// create instructor detail
		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.luv2code.com/youtube",
				"love to code");
		 */

		// create the instructor
		Instructor tempInstructor = new Instructor("Ritik", "Arora", "Ritikarora656@gmail.com");

		// create instructor detail
		InstructorDetail tempInstructorDetail = new InstructorDetail("http://ritik656/youtube",
				"Public Speaking");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// saving the instructor
		System.out.println("Saving instructor: "+tempInstructor);

		// this will also save the details object
		// because of CascadeType.ALL
		appDAO.save(tempInstructor);

		System.out.println("Done");
	}
}
