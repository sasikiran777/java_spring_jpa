package com.springJPA.DemoSpringJPA.controller;

import com.springJPA.DemoSpringJPA.entity.User;
import com.springJPA.DemoSpringJPA.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UsersController {

    @Autowired
    UserServiceImpl userService;

    @GetMapping("/list")
    public List<User> list() {
        return userService.list();
    }
}
