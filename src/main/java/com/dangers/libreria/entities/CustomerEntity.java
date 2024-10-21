package com.dangers.libreria.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@SuppressWarnings("ALL")
@Data
@Entity
@Table(name = "customer")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer", nullable = false)
    private Integer id_customer;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "id_gender")
    private GenderEntity genderEntity;

    @ManyToMany
    @JoinTable(
            name = "loan_customer",
            joinColumns = @JoinColumn(name = "id_customer"),
            inverseJoinColumns = @JoinColumn(name = "id_loan")
    )
    private List<LoanEntity> loans;

    @ManyToMany
    @JoinTable(
            name = "customer_book",
            joinColumns = @JoinColumn(name = "id_customer"),
            inverseJoinColumns = @JoinColumn(name = "id_book")
    )
    private List<BookEntity> books;
}
