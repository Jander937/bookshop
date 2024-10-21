package com.dangers.libreria.repositories;

import com.dangers.libreria.entities.EditorialEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IEditorialRepository extends JpaRepository<EditorialEntity, Integer> {

    @EntityGraph(attributePaths = "books")
    Optional<EditorialEntity> findById(Integer id);
}
