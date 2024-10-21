package com.dangers.libreria.dto;

import com.dangers.libreria.entities.BookEntity;
import lombok.Data;

import java.util.List;

@Data
public class EditorialDTO {
    private Integer id_editorial;

    private String name;

    private String country;

    private String foundationYear;

    private String website;

    private List<BookEntity> books;
}
