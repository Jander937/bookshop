package com.dangers.libreria.service;

import com.dangers.libreria.dto.GenderDTO;
import com.dangers.libreria.entities.GenderEntity;

import java.util.List;

public interface GenderService {
    GenderDTO save(GenderEntity dataGender)throws Exception;

    GenderDTO seachById(Integer id) throws Exception;

    List<GenderDTO> seachAll() throws Exception;

    GenderDTO modify(Integer id, GenderEntity gender) throws Exception;

    Boolean deleteById(Integer id);
}
