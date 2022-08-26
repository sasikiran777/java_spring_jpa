package com.springJPA.DemoSpringJPA.service;

import com.springJPA.DemoSpringJPA.entity.User;
import com.springJPA.DemoSpringJPA.repository.UsersRepository;
import com.springJPA.DemoSpringJPA.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UsersRepository usersRepository;

    public List<User> list() {
        return usersRepository.findAll();
    }

    public User saveAuthor(Map<String, ?> requestBody) {
        User user = new User();
        user.setRole("author");
        user.setName(requestBody.get("name").toString());
        user.setEmail(requestBody.get("email").toString());
        user.setPassword(requestBody.get("password").toString());
        return usersRepository.save(user);
    }

}
