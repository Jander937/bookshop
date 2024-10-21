package com.dangers.libreria.controller;

import com.dangers.libreria.dto.errorDTO.AuthorErrorDTO;
import com.dangers.libreria.entities.AuthorEntity;
import com.dangers.libreria.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v6/author")
public class AuhtorController {
    @Autowired
    AuthorService authorService;

    @PostMapping("/save")
    public ResponseEntity<?> add(@RequestBody AuthorEntity data){
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.authorService.save(data));
        } catch (Exception e) {
            AuthorErrorDTO err = new AuthorErrorDTO();
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
                    .body(this.authorService.seachById(id));
        } catch (Exception e) {
            AuthorErrorDTO err = new AuthorErrorDTO();
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
                    .body(this.authorService.seachAll());
        } catch (Exception e) {
            AuthorErrorDTO err = new AuthorErrorDTO();
            err.setMensajeError(e.getMessage());

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(err.getMensajeError());
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> modificarPropuesta(@RequestBody AuthorEntity data, @PathVariable Integer id){
        try {
            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(this.authorService.modify(id, data));
        } catch (Exception e) {
            AuthorErrorDTO err = new AuthorErrorDTO();
            err.setMensajeError(e.getMessage());

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(err.getMensajeError());
        }
    }
    @DeleteMapping(value = "/delete/{id}")
    public Optional<ResponseEntity<?>> delete(@PathVariable int id){

        Boolean result = authorService.deleteById(id);

        if (result){
            return Optional.of(ResponseEntity.noContent().build());
        }
        return Optional.of(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }
}
