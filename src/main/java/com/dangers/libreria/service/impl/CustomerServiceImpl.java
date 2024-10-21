package com.dangers.libreria.service.impl;

import com.dangers.libreria.dto.CustomerDTO;
import com.dangers.libreria.entities.CustomerEntity;
import com.dangers.libreria.mapper.ICustomerMapper;
import com.dangers.libreria.repositories.ICustomerRepository;
import com.dangers.libreria.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    ICustomerRepository iCustomerRepository;

    @Autowired
    ICustomerMapper iCustomerMapper;

    @Override
    public CustomerDTO save(CustomerEntity dataCustomer)throws Exception{
        try {
            return this.iCustomerMapper.customerToDTO(this.iCustomerRepository.save(dataCustomer));
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    @Override
    public CustomerDTO seachById(Integer id) throws Exception{
        Optional<CustomerEntity> customerOptional = this.iCustomerRepository.findById(id);
        if (customerOptional.isPresent()){
            return this.iCustomerMapper.customerToDTO(customerOptional.get());
        }else {
            throw new Exception("Customer not found with the given ID" + id);
        }
    }
    @Override
    public List<CustomerDTO> seachCustomer() throws Exception{
        try {
            return this.iCustomerMapper.toDTOList(iCustomerRepository.findAll());
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    @Override
    public CustomerDTO modifyCustomer(Integer id, CustomerEntity customer) throws Exception {
        try {
            if (this.iCustomerRepository.findById(id).isPresent()){
                CustomerEntity objectFound = this.iCustomerRepository.findById(id).get();
                objectFound.setName(objectFound.getName());
                objectFound.setId_customer(objectFound.getId_customer());
                objectFound.setCity(objectFound.getCity());
                objectFound.setEmail(objectFound.getEmail());
                objectFound.setCountry(objectFound.getCountry());
                objectFound.setAddress(objectFound.getAddress());
                objectFound.setLastName(objectFound.getLastName());

                return this.iCustomerMapper.customerToDTO(iCustomerRepository.save(objectFound));
            }else{
                throw new Exception("Customer not found");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    @Override
    public Boolean deleteCustomer(Integer id){
        Optional<CustomerEntity> deleteCustomer = iCustomerRepository.findById(id);

        if (deleteCustomer.isEmpty())
            return false;

        iCustomerRepository.deleteById(id);

        return true;
    }
}
