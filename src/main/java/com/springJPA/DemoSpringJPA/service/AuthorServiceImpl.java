package com.springJPA.DemoSpringJPA.service;

import com.springJPA.DemoSpringJPA.dto.AuthorsDTO;
import com.springJPA.DemoSpringJPA.entity.Authors;
import com.springJPA.DemoSpringJPA.repository.AuthorRepository;
import com.springJPA.DemoSpringJPA.service.interfaces.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    UserServiceImpl userService;

    public List<AuthorsDTO> list() {
        return (authorRepository
                .findAll())
                .stream()
                .map(this::convertDataIntoDTO)
                .collect(Collectors.toList());
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

    public AuthorsDTO convertDataIntoDTO (Authors authorData) {
        // create instance of our UserLocationDTO class
        AuthorsDTO dto = new AuthorsDTO();

        //set username and userId in dto from the userData
        dto.setId(authorData.getId());
        dto.setName(authorData.getName());
        dto.setAchievements(authorData.getAchievements());
        dto.setNoOfBooks(authorData.getBooks().size());
        dto.setCreatedAt(authorData.getCreatedAt());
        dto.setUser(authorData.getUser());
        return dto;
    }
}
