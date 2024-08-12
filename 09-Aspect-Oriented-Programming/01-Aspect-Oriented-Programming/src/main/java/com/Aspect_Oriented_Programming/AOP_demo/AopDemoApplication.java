package com.Aspect_Oriented_Programming.AOP_demo;

import com.Aspect_Oriented_Programming.AOP_demo.dao.AccountDAO;
import com.Aspect_Oriented_Programming.AOP_demo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO){
		return runner ->{
			downTheBeforeAdvice(accountDAO, membershipDAO);
		};
	}

	public void downTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO){
		membershipDAO.addSillyMember();

		Account tempAccount = new Account("Ritik", "Manager");
		accountDAO.addAccount(tempAccount);
	}
}
