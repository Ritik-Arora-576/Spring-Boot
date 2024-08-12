package com.Aspect_Oriented_Programming.AOP_demo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {
    // Combining pointcut expression: Includes all methods except getters and setters
    @Pointcut("execution(* com.Aspect_Oriented_Programming.AOP_demo.dao.*.*(..))")
    public void includesAll(){}

    @Pointcut("execution(* com.Aspect_Oriented_Programming.AOP_demo.dao.*.get*(..))")
    public void getterExpression(){}

    @Pointcut("execution(* com.Aspect_Oriented_Programming.AOP_demo.dao.*.set*(..))")
    public void setterExpression(){}

    @Pointcut("includesAll() && !(getterExpression() || setterExpression())")
    public void includesAllExceptGetterAndSetter(){}
}
