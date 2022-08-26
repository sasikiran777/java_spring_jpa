package com.springJPA.DemoSpringJPA.repository;

import com.springJPA.DemoSpringJPA.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<User, Long> {
}
