package com.dangers.libreria.entities;

import com.dangers.libreria.helpers.Status;
import jakarta.persistence.*;
import lombok.Data;

@SuppressWarnings("ALL")
@Data
@Entity
@Table(name = "loan")
public class LoanEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_loan", nullable = false)
    private Integer id_loan;

    @Column(name = "loan_date")
    private String loanDate;

    @Column(name = "return_date")
    private String return_date;

    @ManyToOne
    @JoinColumn(name = "id_customer")
    private CustomerEntity customerEntity;

    @ManyToOne
    @JoinColumn(name = "id_book")
    private BookEntity bookEntity;
}
