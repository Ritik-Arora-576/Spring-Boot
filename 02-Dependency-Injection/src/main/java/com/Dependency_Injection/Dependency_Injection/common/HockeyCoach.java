package com.Dependency_Injection.Dependency_Injection.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("HockeyCoach")
@Lazy // "Lazy" annotation is used whe Bean will only be initialized when needed for dependency injection. It's also known as Lazy Initialization
public class HockeyCoach implements Coach{
    @Override
    public String getDailyWorkout(){
        return "Chak de India !!";
    }
}
