package com.springJPA.DemoSpringJPA.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "authors"})
public class Books {

    @Id
    @SequenceGenerator(allocationSize = 1, sequenceName = "books_sequence", name = "books_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "books_sequence")
    private Long id;
    private String name;
    private String pageCount;
    private String isbn;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Authors authors;

}
