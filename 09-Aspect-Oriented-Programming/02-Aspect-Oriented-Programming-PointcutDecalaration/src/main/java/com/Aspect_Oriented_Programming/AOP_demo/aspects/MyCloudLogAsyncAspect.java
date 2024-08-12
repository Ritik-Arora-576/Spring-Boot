package com.Aspect_Oriented_Programming.AOP_demo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

// Order annotation is used to order the execution of advices for multiple aspects as the order is undefined by Spring
@Aspect
@Component
@Order(2)
public class MyCloudLogAsyncAspect {
    @Before("com.Aspect_Oriented_Programming.AOP_demo.aspects.AopExpressions.includesAllExceptGetterAndSetter()")
    public void logToCloudAsync(){
        System.out.println("Logging to Cloud in async fashion.");
    }
}
