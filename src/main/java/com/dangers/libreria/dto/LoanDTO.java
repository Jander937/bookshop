package com.dangers.libreria.dto;

import com.dangers.libreria.entities.BookEntity;
import com.dangers.libreria.entities.CustomerEntity;
import com.dangers.libreria.helpers.Status;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class LoanDTO {

    private Integer id_loan;

    private String loanDate;

    private String return_date;

    private CustomerEntity customerEntity;

    private BookEntity bookEntity;
}
