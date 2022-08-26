package com.springJPA.DemoSpringJPA.service;

import com.springJPA.DemoSpringJPA.entity.Authors;
import com.springJPA.DemoSpringJPA.entity.Books;
import com.springJPA.DemoSpringJPA.repository.BooksRepository;
import com.springJPA.DemoSpringJPA.service.interfaces.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class BooksServiceImpl implements BooksService {

    @Autowired
    BooksRepository booksRepository;

    @Autowired
    AuthorServiceImpl authorService;

    @Override
    public List<Books> list() {
        return booksRepository.findAll();
    }

    @Override
    public Books save(Map<String, ?> data) throws Exception {
        Books books = new Books();
        books.setName((String) data.get("name"));
        books.setPageCount((String) data.get("pageCount"));
        books.setIsbn((String) data.get("isbn"));
        Optional<Authors> authors = authorService.findById(Long.valueOf(data.get("author").toString()));
        if (authors.isPresent()) {
            books.setAuthors(authors.get());
            return booksRepository.save(books);
        }
        throw new Exception("Something went wrong");
    }


}
