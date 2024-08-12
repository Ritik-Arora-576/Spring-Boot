package com.Dependency_Injection.Dependency_Injection.config;

import com.Dependency_Injection.Dependency_Injection.common.Coach;
import com.Dependency_Injection.Dependency_Injection.common.swimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    // Creating a Spring Bean
    // Defining an ID into Spring Bean as aquatic
    @Bean("aquatic")
    public Coach swimCoach(){
        return new swimCoach();
    }
}
