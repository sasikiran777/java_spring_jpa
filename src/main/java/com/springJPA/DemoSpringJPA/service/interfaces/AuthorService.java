package com.springJPA.DemoSpringJPA.service.interfaces;

import com.springJPA.DemoSpringJPA.entity.Authors;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface AuthorService {

    public List<Authors> list();

    public Authors save(Map<String, ?> requestBody);

    public Optional<Authors> findById (Long id);

    }
