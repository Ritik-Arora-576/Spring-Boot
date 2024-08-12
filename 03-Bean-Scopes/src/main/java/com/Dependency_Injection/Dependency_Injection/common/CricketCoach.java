package com.Dependency_Injection.Dependency_Injection.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// component annotation mark the class as a Spring Bean
@Component("CricketCoach")
// SINGLETON: create only single instance. By default there is a Singleton scope if not mentioned
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) // PROTOTYPE: create new instances each time when requested
public class CricketCoach implements Coach {
    @Override
    public String getDailyWorkout(){
        return "Boys Played Well !!";
    }
}
