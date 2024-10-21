package com.dangers.libreria.repositories;

import com.dangers.libreria.entities.LoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILoanRepository extends JpaRepository<LoanEntity, Integer> {
}
