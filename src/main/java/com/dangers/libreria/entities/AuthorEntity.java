package com.dangers.libreria.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@SuppressWarnings("ALL")
@Data
@Entity
@Table(name = "author")
public class AuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_author", nullable = false)
    private Integer id_author;

    @Column(name = "name_author")
    private String nameAuthor;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birthdate")
    private String birthdate;

    @Column(name = "nationality")
    private String nationality;

    @ManyToMany(mappedBy = "authors")
    private List<BookEntity> books;
}
