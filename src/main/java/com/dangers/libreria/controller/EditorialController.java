package com.dangers.libreria.controller;

import com.dangers.libreria.dto.errorDTO.EditorialErrorDTO;
import com.dangers.libreria.entities.EditorialEntity;
import com.dangers.libreria.service.EditorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v3/editorial")
public class EditorialController {
    @Autowired
    EditorialService editorialService;

    @PostMapping("/save")
    public ResponseEntity<?> add(@RequestBody EditorialEntity data){
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.editorialService.add(data));
        } catch (Exception e) {
            EditorialErrorDTO err = new EditorialErrorDTO();
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
                    .body(this.editorialService.seachById(id));
        } catch (Exception e) {
            EditorialErrorDTO err = new EditorialErrorDTO();
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
                    .body(this.editorialService.seachAll());
        } catch (Exception e) {
            EditorialErrorDTO err = new EditorialErrorDTO();
            err.setMensajeError(e.getMessage());

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(err.getMensajeError());
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> modify(@RequestBody EditorialEntity data, @PathVariable Integer id){
        try {
            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(this.editorialService.modify(id, data));
        } catch (Exception e) {
            EditorialErrorDTO err = new EditorialErrorDTO();
            err.setMensajeError(e.getMessage());

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(err.getMensajeError());
        }
    }
    @DeleteMapping(value = "/{id}")
    public Optional<ResponseEntity<?>> delete(@PathVariable int id){

        Boolean result = editorialService.deleteById(id);

        if (result){
            return Optional.of(ResponseEntity.noContent().build());
        }
        return Optional.of(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }
}
