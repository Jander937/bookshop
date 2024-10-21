package com.dangers.libreria.service;

import com.dangers.libreria.dto.BookCoverDTO;
import com.dangers.libreria.entities.BookCoverEntity;

import java.util.List;

public interface BookCoverService {
    BookCoverDTO save(BookCoverEntity dataBookCover)throws Exception;

    BookCoverDTO seachById(Integer id)throws Exception;

    List<BookCoverDTO> seachAll()throws Exception;

    BookCoverDTO modify(Integer id, BookCoverEntity bookCover)throws Exception;

    Boolean delete(Integer id);
}
