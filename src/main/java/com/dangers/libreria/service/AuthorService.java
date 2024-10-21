package com.dangers.libreria.service;

import com.dangers.libreria.dto.AuthorDTO;
import com.dangers.libreria.entities.AuthorEntity;

import java.util.List;

public interface AuthorService {
    AuthorDTO save(AuthorEntity dataAuthor)throws Exception;

    AuthorDTO seachById(Integer id) throws Exception;

    List<AuthorDTO> seachAll()throws Exception;

    AuthorDTO modify(Integer id, AuthorEntity author) throws Exception;

    Boolean deleteById(Integer id);
}
