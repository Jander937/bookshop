package com.dangers.libreria.entities;

import jakarta.persistence.*;
import lombok.Data;

@SuppressWarnings("ALL")
@Data
@Entity
@Table(name = "book_cover")
public class BookCoverEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_book_cover", nullable = false)
    private Integer id_book_cover;

    @Column(name = "cover_image")
    private String coverImage;

    @OneToOne
    @JoinColumn(name = "id_book")
    private BookEntity bookEntity;

}
