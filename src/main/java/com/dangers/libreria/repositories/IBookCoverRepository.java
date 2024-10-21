package com.dangers.libreria.repositories;

import com.dangers.libreria.entities.BookCoverEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookCoverRepository extends JpaRepository <BookCoverEntity, Integer> {
}
