package com.springJPA.DemoSpringJPA.repository;

import com.springJPA.DemoSpringJPA.entity.Authors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Authors, Long> {
}
