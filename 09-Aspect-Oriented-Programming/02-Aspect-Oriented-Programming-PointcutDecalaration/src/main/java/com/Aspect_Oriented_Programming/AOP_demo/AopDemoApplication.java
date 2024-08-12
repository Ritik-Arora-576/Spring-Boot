package com.Aspect_Oriented_Programming.AOP_demo;

import com.Aspect_Oriented_Programming.AOP_demo.dao.AccountDAO;
import com.Aspect_Oriented_Programming.AOP_demo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class AopDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO){
		return runner ->{
//			downTheBeforeAdvice(accountDAO, membershipDAO);
//			downTheAfterRunAdvice(accountDAO);
			downTheAfterThrowingAdvice(accountDAO);
		};
	}

	public void downTheAfterThrowingAdvice(AccountDAO accountDAO) {
		List<Account> accounts = null;

		try{
			accounts = accountDAO.findAccounts();
		} catch(Exception exc){
			System.out.println("Exception: "+exc);
		}

		System.out.println(accounts);
	}

	public void downTheAfterRunAdvice(AccountDAO accountDAO) {
		List<Account> accounts = accountDAO.findAccounts();

		System.out.println(accounts);
	}

	public void downTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershi