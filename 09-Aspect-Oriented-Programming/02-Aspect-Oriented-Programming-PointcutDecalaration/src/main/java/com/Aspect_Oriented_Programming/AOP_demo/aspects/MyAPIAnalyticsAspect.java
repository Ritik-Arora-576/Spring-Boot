package com.Aspect_Oriented_Programming.AOP_demo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyAPIAnalyticsAspect {
    @Before("com.Aspect_Oriented_Programming.AOP_demo.aspects.AopExpressions.includesAllExceptGetterAndSetter()")
    public void performAPIAnalytics(){
        System.out.println("Performing API analytics.");
    }
}
