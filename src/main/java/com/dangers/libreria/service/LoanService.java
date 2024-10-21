package com.dangers.libreria.service;

import com.dangers.libreria.dto.LoanDTO;
import com.dangers.libreria.entities.LoanEntity;

import java.util.List;

public interface LoanService {
    LoanDTO save(LoanEntity dataLoan)throws Exception;

    LoanDTO seachById(Integer id) throws Exception;

    List<LoanDTO> seachAll()throws Exception;

    LoanDTO modify(Integer id, LoanEntity loan) throws Exception;

    Boolean deleteLoan(Integer id);
}
