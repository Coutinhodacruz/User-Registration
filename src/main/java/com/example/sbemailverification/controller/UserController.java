package com.example.sbemailverification.controller;

import com.example.sbemailverification.services.UserServices;
import com.example.sbemailverification.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserServices userServices;


    @GetMapping
    public List<User> getUsers(){

        return userServices.getUsers();
    }
}
