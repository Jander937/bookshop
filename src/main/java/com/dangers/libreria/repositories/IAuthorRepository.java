package com.dangers.libreria.repositories;

import com.dangers.libreria.entities.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthorRepository extends JpaRepository<AuthorEntity, Integer> {
}
