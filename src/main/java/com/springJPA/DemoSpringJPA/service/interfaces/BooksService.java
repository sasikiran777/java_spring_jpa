package com.springJPA.DemoSpringJPA.service.interfaces;

import com.springJPA.DemoSpringJPA.entity.Books;

import java.util.List;
import java.util.Map;

public interface BooksService {

    public List<Books> list();

    public Books save(Map<String, ?> data) throws Exception;
}
