package com.Dependency_Injection.Dependency_Injection.rest;

import com.Dependency_Injection.Dependency_Injection.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    /*
    // define a private field for the dependency
    @Autowired // use autowired only in the case of feild injection not for constructor and setter injection
    private Coach myCoach;
    // Feild injection is not reccomended by sring.io because it makes code harder to unit test
     */

    private Coach myCoach;

    // @Autowired annotation tells Spring to inject the dependency
    // @Qualifier annotation is used to specify which class dependency would get inject
    // Constructor Injection
    @Autowired
    public DemoController(@Qualifier("HockeyCoach") Coach theCoach){
        this.myCoach = theCoach;
    }

    /*
    // setter injection
    @Autowired
    public void setCoach(@Qualifier("HockeyCoach") Coach theCoach){
        this.myCoach = theCoach;
    }
     */

    @GetMapping("/dailyWorkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
}
