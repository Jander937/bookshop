package com.dangers.libreria.repositories;

import com.dangers.libreria.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<CustomerEntity, Integer> {
}
