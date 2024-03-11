package com.example.novi_be10_techiteasy.controllers;

import com.example.novi_be10_techiteasy.exceptions.RecordNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//annotaties exceptioncontroller class
@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(value = RecordNotFoundException.class)//exception controllermethod basisopdracht
    public ResponseEntity<Object> exception(RecordNotFoundException exception)
    {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    //bonus opdracht B6: out of bounds exception. deze vangt de standaard Java index-out-of-bounds error op en geeft een http statuscode terug in een responseentity ipv de console melding.
    @ExceptionHandler(value = IndexOutOfBoundsException.class)
    public ResponseEntity<Object> exception(IndexOutOfBoundsException exception){
        return new ResponseEntity<>("Dit id bestaat niet",HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = TelevisionNameTooLongException.class)//bonus bonus opdracht 1 hiervoor maken we zelf de exception class in het exceptionmapje.
    public ResponseEntity<String> exception(TelevisionNameTooLongException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
