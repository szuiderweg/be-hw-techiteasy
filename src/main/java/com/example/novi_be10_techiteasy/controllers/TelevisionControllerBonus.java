package com.example.novi_be10_techiteasy.controllers;

import com.example.novi_be10_techiteasy.exceptions.RecordNotFoundException;
import com.example.novi_be10_techiteasy.exceptions.TelevisionNameTooLongException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/bonustv")
public class TelevisionControllerBonus {
    //de lijst is static omdat er maar 1 tv lijst kan zijn (als dit tenminste de enige tv controller zou zijn)
    //de lijst is final om dat (eigenschappen van) de lijst zelf niet verandert, wel de waarden die erin staan
    private static final List<String> televisionDatabase = new ArrayList<>();

    @GetMapping("/televisions")
    public ResponseEntity<List<String>> getAllTelevisions() {
        //return complete lijst met 200 status
        return ResponseEntity.ok(televisionDatabase);
    }

    @GetMapping("/televisions/{id}")
    public ResponseEntity<String> getTelevision(@PathVariable int id){
        //Return de waarde die op index (id) staat en een 200 status
        //Wanneer de gebruiker een request met id=300 , maar de lijst heeft maar 3 items,
        //Dan gooit java een IndexoutOfBoundsException. de bonusmethode in ExceptionController vangt dit op en stuurt de
        //gebruiker een berichtje.
        return ResponseEntity.ok(televisionDatabase.get(id));
    }

    @PostMapping("/televisions/{id}")
    public ResponseEntity<String> addTelevision(@RequestBody String television){
        //bonus bonus: check television string op lengte > 20, als het te lang is, throw de bijbehorende custom exception
        if(television.length()>20){//check op exception met if-statement ipv try-catch blokken
            throw new TelevisionNameTooLongException("televisienaam is te lang");
        }else{
            //voeg de tv uit de parameter toe aan de tvdatabase-lijst
            televisionDatabase.add(television);
            //return de tv uit de parameter samen met een 201 status
            return ResponseEntity.created(null).body(television);
        }
    }

    @DeleteMapping("/televisions/{id}")
    public ResponseEntity<Void> deleteTelevision(@PathVariable int id){
        //vervang de waarde op index(id) met null. Als we de waarde zouden verwijderen, zouden alle indexen die na deze waarde komen in de lijst met 1 afnemen.
        televisionDatabase.set(id, null);
        //return een 204 status
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/televisions/{id}")
    public ResponseEntity<Void> updateTelevision(@PathVariable int id, @RequestBody String television){
        //in de vorige methodes hebben we impliciet gebruik gemaakt van de Java "IndexOutOfBoundsException" als het id groter was dan de lengte van de lijst.
        //In deze methode checken we daar expliciet voor en gooien we een custom exception op.
        if(televisionDatabase.isEmpty() || id> televisionDatabase.size()){
            throw new RecordNotFoundException("Record met id: "+id+ " niet gevonden in de database.");
        }else {//vervang de waarde op index(id) met de television uit de parameter
            televisionDatabase.set(id, television);
            //return een 204 status
            return ResponseEntity.noContent().build();
        }
    }
}
