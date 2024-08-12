package com.Dependency_Injection.Dependency_Injection.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

// component annotation mark the class as a Spring Bean
@Component("CricketCoach")
// If Qualifier keyword is not mentioned in DemoController then by default CricketCoach class will be injected by using Primary annotation
@Primary
public class CricketCoach implements Coach {
    @Override
    public String getDailyWorkout(){
        return "Boys Played Well !!";
    }
}
