package com.dangers.libreria.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@SuppressWarnings("ALL")
@Data
@Entity
@Table(name = "editorial")
public class EditorialEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_editorial", nullable = false)
    private Integer id_editorial;

    @Column(name = "name")
    private String name;

    @Column(name = "country")
    private String country;

    @Column(name = "foundation_year")
    private String foundationYear;

    @Column(name = "website")
    private String website;

    @OneToMany(mappedBy = "editorialEntity")
    private List<BookEntity> books;
}
