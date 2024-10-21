package com.dangers.libreria.dto;

import com.dangers.libreria.entities.CustomerEntity;
import lombok.Data;

import java.util.List;

@Data
public class GenderDTO {

    private Integer id_gender;

    private String name;

    private List<CustomerEntity> customers;
}
