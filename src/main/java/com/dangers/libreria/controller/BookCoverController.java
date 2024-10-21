package com.dangers.libreria.controller;

import com.dangers.libreria.dto.errorDTO.BookCoverErrorDTO;
import com.dangers.libreria.entities.BookCoverEntity;
import com.dangers.libreria.entities.BookEntity;
import com.dangers.libreria.service.BookCoverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v2/bookC")
public class BookCoverController {

    @Autowired
    BookCoverService bookCoverService;

    @PostMapping("/save")
    public ResponseEntity<?> add(@RequestBody BookCoverEntity dataReceived){
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.bookCoverService.save(dataReceived));
        } catch (Exception e) {
            BookCoverErrorDTO error = new BookCoverErrorDTO();
            error.setMensajeError(e.getMessage());

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMensajeError());
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> seachById(@PathVariable Integer id){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.bookCoverService.seachById(id));
        } catch (Exception e) {
            BookCoverErrorDTO err = new BookCoverErrorDTO();
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
                    .body(this.bookCoverService.seachAll());
        } catch (Exception e) {
            BookCoverErrorDTO err = new BookCoverErrorDTO();
            err.setMensajeError(e.getMessage());

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(err.getMensajeError());
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> modificarPropuesta(@RequestBody BookCoverEntity data, @PathVariable Integer id){
        try {
            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(this.bookCoverService.modify(id, data));
        } catch (Exception e) {
            BookCoverErrorDTO err = new BookCoverErrorDTO();
            err.setMensajeError(e.getMessage());

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(err.getMensajeError());
        }
    }
    @DeleteMapping(value = "/{id}")
    public Optional<ResponseEntity<?>> delete(@PathVariable int id){

        Boolean result = bookCoverService.delete(id);

        if (result){
            return Optional.of(ResponseEntity.noContent().build());
        }
        return Optional.of(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }
}
