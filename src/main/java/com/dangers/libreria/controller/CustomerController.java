package com.dangers.libreria.controller;

import com.dangers.libreria.dto.errorDTO.CustomerErrorDTO;
import com.dangers.libreria.entities.CustomerEntity;
import com.dangers.libreria.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping("/save")
    public ResponseEntity<?> add(@RequestBody CustomerEntity data){
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.customerService.save(data));
        } catch (Exception e) {
            CustomerErrorDTO err = new CustomerErrorDTO();
            err.setMensajeError(e.getMessage());

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(err.getMensajeError());
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> seachById(@PathVariable Integer id){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.customerService.seachById(id));
        } catch (Exception e) {
            CustomerErrorDTO err = new CustomerErrorDTO();
            err.setMensajeError(e.getMessage());

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(err.getMensajeError());
        }
    }
    @GetMapping("/seach")
    public ResponseEntity<?>seachAll(){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.customerService.seachCustomer());
        } catch (Exception e) {
            CustomerErrorDTO err = new CustomerErrorDTO();
            err.setMensajeError(e.getMessage());

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(err.getMensajeError());
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> modify(@RequestBody CustomerEntity data, @PathVariable Integer id){
        try {
            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(this.customerService.modifyCustomer(id, data));
        } catch (Exception e) {
            CustomerErrorDTO err = new CustomerErrorDTO();
            err.setMensajeError(e.getMessage());

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(err.getMensajeError());
        }
    }
    @DeleteMapping(value = "/{id}")
    public Optional<ResponseEntity<?>> delete(@PathVariable int id){

        Boolean result = customerService.deleteCustomer(id);

        if (result){
            return Optional.of(ResponseEntity.noContent().build());
        }
        return Optional.of(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }
}
