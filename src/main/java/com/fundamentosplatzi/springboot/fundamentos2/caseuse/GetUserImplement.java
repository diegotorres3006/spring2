package com.fundamentosplatzi.springboot.fundamentos2.caseuse;

import com.fundamentosplatzi.springboot.fundamentos2.emtity.User;
import com.fundamentosplatzi.springboot.fundamentos2.service.UserService;

import java.util.List;

public class GetUserImplement implements GetUser{
    private UserService userService;

    public GetUserImplement(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<User> getAll() {
        return userService.getAllUsers();
    }
}
