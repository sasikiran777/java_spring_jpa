package com.springJPA.DemoSpringJPA.service;

import com.springJPA.DemoSpringJPA.entity.Authors;
import com.springJPA.DemoSpringJPA.repository.AuthorRepository;
import com.springJPA.DemoSpringJPA.service.interfaces.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    UserServiceImpl userService;

    public List<Authors> list() {
        return authorRepository.findAll();
    }

    public Authors save(Map<String, ?> requestBody) {
        Authors authors = new Authors();
        authors.setName(requestBody.get("name").toString());
        authors.setAchievements(requestBody.get("achievements").toString());
        authors.setUser(userService.saveAuthor(requestBody));
        return authorRepository.save(authors);
    }

    public Optional<Authors> findById (Long id) {
        return authorRepository.findById(id);
    }
}
