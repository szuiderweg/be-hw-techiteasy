package com.example.novi_be10_techiteasy.exceptions;

//custom exception voor te lange tvnaam
public class TelevisionNameTooLongException extends RuntimeException{

    public TelevisionNameTooLongException(){
        super();
    }

    public TelevisionNameTooLongException (String message){
        super(message);
    }
}
