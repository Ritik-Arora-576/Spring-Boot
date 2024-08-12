package com.advance_mapping.advance_mapping;

import com.advance_mapping.advance_mapping.dao.AppDAO;
import com.advance_mapping.advance_mapping.entity.Instructor;
import com.advance_mapping.advance_mapping.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AdvanceMappingApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvanceMappingApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner ->{
//			createInstructor(appDAO);
//			findInstructor(appDAO);
			deleteInstructor(appDAO);
		};
	}

	private void deleteInstructor(AppDAO appDAO){
		int ID=2;
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
