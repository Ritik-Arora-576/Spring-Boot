package com.Dependency_Injection.Dependency_Injection.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("HockeyCoach")
// SINGLETON: create only single instance. By default there is a Singleton scope if not mentioned
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) // PROTOTYPE: create new instances each time when requested
public class HockeyCoach implements Coach{
    // construct to create an instance of object
    public HockeyCoach() {System.out.println("In Constructor: "+getClass().getSimpleName());}

    // define init method
    @PostConstruct
    public void doStartupStuff() {System.out.println("In Constructor: "+getClass().getSimpleName());}

    // define destroy method
    @PreDestroy
    public void doCleanupStuff() {System.out.println("In Constructor: "+getClass().getSimpleName());}

    @Override
    public String getDailyWorkout(){
        return "Chak de India !!";
    }
}
