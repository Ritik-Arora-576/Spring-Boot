package com.Aspect_Oriented_Programming.AOP_demo.aspects;

import com.Aspect_Oriented_Programming.AOP_demo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

// Aspect Class: This class contains advices over multiple classes
@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect {
    // this is where we add all related advices to take an action upon join paths

    // starting with @Before advice
    // within the bracket we mentioned Pointcuts which contains AOP expression.
    // If the AOP expression matches with join point then aspect would execute the advice

    // Below code will execute before the execution of a method addAccount() for all classes which has addAccount() method
    // @Before("execution(public void addAccount())")

    // Below code will execute before the execution of a method addAccount() for AccountDAO interface only
    // @Before("execution(public void com.Aspect_Oriented_Programming.AOP_demo.dao.AccountDAO.addAccount())")

    // Below code will execute before the execution of the methods which starts with "add" followed by any number of characters for all classes
    // @Before("execution(public void add*())")

    // Below code will execute before the execution of the methods which starts with "add" for all classes and for all return types
    // NOTE: Access modifiers are optional to mention
    // @Before("execution(* add*())")

    /*
        PARAM PATTERN:
        1. (): Matches a method with no-argument
        2. (*): Matches a method with one argument of any type
        3. (..): Matches a method with 0 or more arguments of any type
     */

    /* Below code will execute before the execution of the methods
       which starts with "add" for all classes and for all return types
       and contain only one variable of type Account
     */
    // @Before("execution(* add*(com.Aspect_Oriented_Programming.AOP_demo.Account))")

    // Below code will execute before the execution of all the classes and their all methods
    // @Before("execution(* com.Aspect_Oriented_Programming.AOP_demo.dao.*.*(..))")

    // Pointcut declaration, if we wanted to change same pointcut expression for multiple advice then we have to change the expression here only
//    @Pointcut("execution(* com.Aspect_Oriented_Programming.AOP_demo.dao.*.*(..))")
//    private void forDAOpackage() {}
//
//    @Before("forDAOpackage()")
//    public void beforeAddAccountAdvice(){
//        System.out.println("This method is executed before the method Add Account.");
//    }
//
//    @Before("forDAOpackage()")
//    public void beforeAddAccountAdvice2(){
//        System.out.println("This method is executed before the method Add Account Part 2.");
//    }

    @Before("com.Aspect_Oriented_Programming.AOP_demo.aspects.AopExpressions.includesAllExceptGetterAndSetter()")
    public void beforeAddAccountAdvice(){
        System.out.println("This method is executed before the method Add Account.");
    }

    // this advice will run after the successful execution of method fimdAccounts() in accountDAO method
    // return value will store inside List<Account> result
    @AfterReturning(
            pointcut = "execution(* com.Aspect_Oriented_Programming.AOP_demo.dao.AccountDAOImpl.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result){
        // point out on which method we are advices upon
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("This Advice is running after method: "+method);
        System.out.println("Result is: "+result);

        // modifying the name of results into uppercase
        for(Account account:result){
            account.setName(account.getName().toUpperCase());
        }
    }
}
