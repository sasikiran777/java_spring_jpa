package com.springJPA.DemoSpringJPA.controller;

import com.springJPA.DemoSpringJPA.entity.Books;
import com.springJPA.DemoSpringJPA.service.BooksServiceImpl;
import com.springJPA.DemoSpringJPA.service.interfaces.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/books")
public class BooksController {

    @Autowired
    BooksServiceImpl booksService;

    @RequestMapping("/list")
    public List<Books> list() {
        return booksService.list();
    }

    @RequestMapping("/save")
    public Books save(@RequestBody Map<String, ?> data) {
        return booksService.save(data);
    }
}
