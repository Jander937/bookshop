package com.dangers.libreria.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Data
@Entity
@Table(name = "gender")
public class GenderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_gender", nullable = false)
    private Integer id_gender;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "genderEntity")
    private List<CustomerEntity> customers;

}
