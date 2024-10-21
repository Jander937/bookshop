package com.dangers.libreria.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class FactureUtils {
    private FactureUtils(){

    }
    public static ResponseEntity<String> getResponseEntity(String message, HttpStatus httpStatus){
        return new ResponseEntity<String>("Mensaje : " + message, httpStatus);
    }
}
