package com.fundamentosplatzi.springboot.fundamentos2.configuration;

import com.fundamentosplatzi.springboot.fundamentos2.caseuse.GetUser;
import com.fundamentosplatzi.springboot.fundamentos2.caseuse.GetUserImplement;
import com.fundamentosplatzi.springboot.fundamentos2.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class CaseUseConfiguration {
    @Bean
    GetUser getUser(UserService userService){
        return new GetUserImplement(userService);
    }
}
