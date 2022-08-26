package com.springJPA.DemoSpringJPA.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Authors {
    @Id
    @SequenceGenerator(name = "author_sequence", allocationSize = 1, sequenceName = "author_sequence")
    @GeneratedValue(generator = "author_sequence", strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String achievements;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "authors")
    private List<Books> books;
}
