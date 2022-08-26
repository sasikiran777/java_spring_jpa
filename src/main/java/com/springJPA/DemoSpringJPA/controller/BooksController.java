package com.springJPA.DemoSpringJPA.controller;

import com.springJPA.DemoSpringJPA.entity.Books;
import com.springJPA.DemoSpringJPA.service.BooksServiceImpl;
import com.springJPA.DemoSpringJPA.service.interfaces.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/books")
public class BooksController {

    @Autowired
    BooksServiceImpl booksService;

    @GetMapping("/list")
    public List<Books> list() {
        return booksService.list();
    }

    @PostMapping("/save")
    public Books save(@RequestBody Map<String, ?> data) throws Exception {
        return booksService.save(data);
    }
}
