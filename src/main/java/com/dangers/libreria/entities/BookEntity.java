package com.dangers.libreria.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@SuppressWarnings("ALL")
@Data
@Entity
@Table(name = "book")
public class BookEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_book", nullable = false)
    private Integer id_book;

    @Column(name = "title")
    private String title;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "publication_year")
    private String publication_year;

    @OneToOne(mappedBy = "bookEntity")
    private BookCoverEntity bookCoverEntity;

    @ManyToOne
    @JoinColumn(name = "id_editorial")
    private EditorialEntity editorialEntity;

    @ManyToOne
    @JoinColumn(name = "id_gender")
    private GenderEntity genders;

    @ManyToMany
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "id_book"),
            inverseJoinColumns = @JoinColumn(name = "id_author")
    )
    private List<AuthorEntity> authors;

    @OneToMany(mappedBy = "bookEntity")
    private List<LoanEntity> loans;

    @ManyToMany(mappedBy = "books")
    private List<CustomerEntity> customers;
}
