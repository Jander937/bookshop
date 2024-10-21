package com.dangers.libreria.repositories;

import com.dangers.libreria.entities.GenderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGenderRepository extends JpaRepository<GenderEntity, Integer> {
}
