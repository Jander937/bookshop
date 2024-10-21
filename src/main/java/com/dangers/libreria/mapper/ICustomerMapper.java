package com.dangers.libreria.mapper;

import com.dangers.libreria.dto.CustomerDTO;
import com.dangers.libreria.entities.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ICustomerMapper {


    @Mappings({
            @Mapping(source = "id_customer", target = "id_customer"),
            @Mapping(source = "name", target = "name" ),
            @Mapping(source = "lastName", target = "lastName"),
            @Mapping(source = "country", target = "country"),
            @Mapping(source = "city", target = "city"),
            @Mapping(source = "address", target = "address"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "genderEntity", target = "genderEntity"),
            @Mapping(source = "loans", target = "loans"),
            @Mapping(source = "books", target = "books"),
    })

    CustomerDTO customerToDTO(CustomerEntity customer);

    List<CustomerDTO> toDTOList(List<CustomerEntity> customerEntityList);

    default CustomerEntity convertToEntity(CustomerDTO customerDTO) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId_customer(customerDTO.getId_customer());
        customerEntity.setName(customerDTO.getName());
        customerEntity.setLastName(customerDTO.getLastName());
        customerEntity.setAddress(customerDTO.getAddress());
        customerEntity.setCity(customerDTO.getCity());
        customerEntity.setCountry(customerDTO.getCountry());
        customerEntity.setEmail(customerDTO.getEmail());
        // Puedes configurar el mapeo del género u otros campos aquí si es necesario
        return customerEntity;
    }
}
