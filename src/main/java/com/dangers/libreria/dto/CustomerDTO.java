package com.dangers.libreria.dto;

import com.dangers.libreria.entities.BookEntity;
import com.dangers.libreria.entities.GenderEntity;
import com.dangers.libreria.entities.LoanEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
public class CustomerDTO {

    private Integer id_customer;

    private String name;

    private String lastName;

    private String address;

    private String city;

    private String country;

    private String email;

    private GenderEntity genderEntity;

    private List<LoanEntity> loans;

    private List<BookEntity> books;
}
