package com.springJPA.DemoSpringJPA.service.interfaces;

import com.springJPA.DemoSpringJPA.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    public List<User> list();
    public User saveAuthor(Map<String, ?> requestBody);
}
