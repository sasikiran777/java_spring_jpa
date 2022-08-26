package com.springJPA.DemoSpringJPA.controller;

import com.springJPA.DemoSpringJPA.entity.Authors;
import com.springJPA.DemoSpringJPA.service.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorServiceImpl authorService;

    @GetMapping("/list")
    public List<Authors> list() {
        return authorService.list();
    }

    @PostMapping("/save")
    public Authors save(@RequestBody Map<String, ?> requestBody) {
        return authorService.save(requestBody);
    }

}
