package com.dangers.libreria.controller;

import com.dangers.libreria.dto.errorDTO.GenderErrorDTO;
import com.dangers.libreria.entities.GenderEntity;
import com.dangers.libreria.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v4/gender")
public class GenderController {
    @Autowired
    GenderService genderService;

    @PostMapping("/save")
    public ResponseEntity<?> add(@RequestBody GenderEntity data){
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.genderService.save(data));
        } catch (Exception e) {
            GenderErrorDTO err = new GenderErrorDTO();
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
                    .body(this.genderService.seachById(id));
        } catch (Exception e) {
            GenderErrorDTO err = new GenderErrorDTO();
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
                    .body(this.genderService.seachAll());
        } catch (Exception e) {
            GenderErrorDTO err = new GenderErrorDTO();
            err.setMensajeError(e.getMessage());

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(err.getMensajeError());
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> modificarPropuesta(@RequestBody GenderEntity data, @PathVariable Integer id){
        try {
            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(this.genderService.modify(id, data));
        } catch (Exception e) {
            GenderErrorDTO err = new GenderErrorDTO();
            err.setMensajeError(e.getMessage());

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(err.getMensajeError());
        }
    }
    @DeleteMapping(value = "/{id}")
    public Optional<ResponseEntity<?>> delete(@PathVariable int id){

        Boolean result = genderService.deleteById(id);

        if (result){
            return Optional.of(ResponseEntity.noContent().build());
        }
        return Optional.of(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }
}
