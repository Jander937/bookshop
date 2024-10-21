package com.dangers.libreria.service;

import com.dangers.libreria.dto.EditorialDTO;
import com.dangers.libreria.entities.EditorialEntity;
import com.dangers.libreria.entities.GenderEntity;

import java.util.List;

public interface EditorialService {
    EditorialDTO add(EditorialEntity dataEditorial) throws Exception;

    EditorialDTO seachById(Integer id) throws Exception;

    List<EditorialDTO> seachAll()throws Exception;

    EditorialDTO modify(Integer id, EditorialEntity editorial) throws Exception;

    Boolean deleteById(Integer id);
}
