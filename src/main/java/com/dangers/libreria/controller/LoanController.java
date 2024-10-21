package com.dangers.libreria.controller;

import com.dangers.libreria.dto.errorDTO.LoanErrorDTO;
import com.dangers.libreria.entities.LoanEntity;
import com.dangers.libreria.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v7/loan")
public class LoanController {
    @Autowired
    LoanService loanService;

    @PostMapping("/save")
    public ResponseEntity<?> add(@RequestBody LoanEntity data){
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.loanService.save(data));
        } catch (Exception e) {
            LoanErrorDTO err = new LoanErrorDTO();
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
                    .body(this.loanService.deleteLoan(id));
        } catch (Exception e) {
            LoanErrorDTO err = new LoanErrorDTO();
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
                    .body(this.loanService.seachAll());
        } catch (Exception e) {
            LoanErrorDTO err = new LoanErrorDTO();
            err.setMensajeError(e.getMessage());

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(err.getMensajeError());
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> modificarPropuesta(@RequestBody LoanEntity data, @PathVariable Integer id){
        try {
            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(this.loanService.modify(id, data));
        } catch (Exception e) {
            LoanErrorDTO err = new LoanErrorDTO();
            err.setMensajeError(e.getMessage());

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(err.getMensajeError());
        }
    }
    @DeleteMapping(value = "/{id}")
    public Optional<ResponseEntity<?>> delete(@PathVariable int id){

        Boolean result = loanService.deleteLoan(id);

        if (result){
            return Optional.of(ResponseEntity.noContent().build());
        }
        return Optional.of(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }
}
