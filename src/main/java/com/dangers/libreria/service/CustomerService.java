package com.dangers.libreria.service;

import com.dangers.libreria.dto.CustomerDTO;
import com.dangers.libreria.entities.CustomerEntity;

import java.util.List;

public interface CustomerService {
    CustomerDTO save(CustomerEntity dataCustomer)throws Exception;

    CustomerDTO seachById(Integer id) throws Exception;

    List<CustomerDTO> seachCustomer() throws Exception;

    CustomerDTO modifyCustomer(Integer id, CustomerEntity customer) throws Exception;

    Boolean deleteCustomer(Integer id);
}
