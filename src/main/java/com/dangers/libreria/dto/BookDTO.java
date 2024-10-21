package com.dangers.libreria.dto;

import com.dangers.libreria.entities.*;
import lombok.Data;

import java.util.List;

@Data
public class BookDTO {

    private Integer id_book;

    private String title;

    private String isbn;

    private String publication_year;

    private BookCoverEntity bookCoverEntity;

    private List<AuthorEntity> authors;

    private List<LoanEntity> loans;

    private GenderEntity genders;

    private List<CustomerEntity> customers;

    private EditorialEntity editorialEntity;
}
