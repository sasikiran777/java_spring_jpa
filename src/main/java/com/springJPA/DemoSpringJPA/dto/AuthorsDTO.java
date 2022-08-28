package com.springJPA.DemoSpringJPA.dto;

import com.springJPA.DemoSpringJPA.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorsDTO {
    private Long id;
    private String name;
    private String achievements;
    private Date createdAt;
    private Date updatedAt;
    private Integer noOfBooks;
    private User user;
}
