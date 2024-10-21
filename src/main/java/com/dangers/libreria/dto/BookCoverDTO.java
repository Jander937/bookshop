package com.dangers.libreria.dto;

import com.dangers.libreria.entities.BookEntity;
import lombok.Data;

@Data
public class BookCoverDTO {

    private Integer id_book_cover;

    private String urlImage;

    private BookEntity bookEntity;
}
