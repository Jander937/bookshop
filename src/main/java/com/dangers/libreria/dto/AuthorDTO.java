package com.dangers.libreria.dto;

import com.dangers.libreria.entities.BookEntity;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.List;

@Data
public class AuthorDTO {

    private Integer id_author;

    private String nameAuthor;

    private String lastName;

    private String birthdate;

    private String nationality;

    private List<BookEntity> books;
}
