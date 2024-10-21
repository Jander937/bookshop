package com.dangers.libreria.service.impl;

import com.dangers.libreria.dto.LoanDTO;
import com.dangers.libreria.entities.LoanEntity;
import com.dangers.libreria.mapper.ILoanMapper;
import com.dangers.libreria.repositories.ILoanRepository;
import com.dangers.libreria.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanServiceImpl implements LoanService {

    @Autowired
    ILoanRepository iLoanRepository;

    @Autowired
    ILoanMapper iLoanMapper;

    @Override
    public LoanDTO save(LoanEntity dataLoan)throws Exception{
        try {
            return this.iLoanMapper.loanToDTO(this.iLoanRepository.save(dataLoan));
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    @Override
    public LoanDTO seachById(Integer id) throws Exception {
        Optional<LoanEntity> loanOptional = this.iLoanRepository.findById(id);
        if (loanOptional.isPresent()){
            return this.iLoanMapper.loanToDTO(loanOptional.get());
        }else {
            throw new Exception("loan not found with the given ID " + id);
        }
    }
    @Override
    public List<LoanDTO> seachAll()throws Exception{
        try {
            return this.iLoanMapper.toDTOlist(iLoanRepository.findAll());
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    @Override
    public LoanDTO modify(Integer id, LoanEntity loan) throws Exception{
        try {
            if (this.iLoanRepository.findById(id).isPresent()){
                LoanEntity objectFound = this.iLoanRepository.findById(id).get();
                objectFound.setId_loan(objectFound.getId_loan());
                objectFound.setLoanDate(objectFound.getLoanDate());
                objectFound.setBookEntity(objectFound.getBookEntity());
                objectFound.setReturn_date(objectFound.getReturn_date());
                objectFound.setCustomerEntity(objectFound.getCustomerEntity());
                return this.iLoanMapper.loanToDTO(iLoanRepository.save(objectFound));
            }else {
                throw new Exception("Propuesta not found");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }

    }
    @Override
    public Boolean deleteLoan(Integer id){
        Optional<LoanEntity> deleteLoan = iLoanRepository.findById(id);

        if (deleteLoan.isEmpty())
            return false;

        iLoanRepository.deleteById(id);

        return true;
    }
}
