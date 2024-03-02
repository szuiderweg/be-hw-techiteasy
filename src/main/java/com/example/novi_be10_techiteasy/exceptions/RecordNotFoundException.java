package com.example.novi_be10_techiteasy.exceptions;

public class RecordNotFoundException extends RuntimeException{
    public RecordNotFoundException(){
        super();
    }

    public RecordNotFoundException(String message){
        super(message);
    }
}
