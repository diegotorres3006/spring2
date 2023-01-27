package com.fundamentosplatzi.springboot.fundamentos2.caseuse;

import com.fundamentosplatzi.springboot.fundamentos2.emtity.User;
import com.fundamentosplatzi.springboot.fundamentos2.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class CreateUser {
    private UserService userService;

    public CreateUser(UserService userService) {
        this.userService = userService;
    }

    public User save(User newUser) {
        return userService.save(newUser);
    }
}
