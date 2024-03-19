package com.example.novi_be10_techiteasy.exceptions;

//deze klasse vormt onze custom exception
public class RecordNotFoundException extends RuntimeException{
    // de exception zonder message
    public RecordNotFoundException(){
        super();
    }

    //exception met message
    public RecordNotFoundException(String message){
        super(message);
    }
}
