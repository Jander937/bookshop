package com.dangers.libreria.repositories;

import com.dangers.libreria.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository <BookEntity, Integer> {
}
