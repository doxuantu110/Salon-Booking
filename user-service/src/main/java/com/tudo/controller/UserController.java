package com.tudo.controller;

import com.tudo.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("/api/user")
    public User getUser(){
        User user = new User();
        user.setFullName("TuDo");
        user.setEmail("xuantudo@gmail.com");
        user.setRole("admin");
        return user;
    }

}
