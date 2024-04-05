
//hier maken we nog een controller, maar deze geeft alleen de String returntypes , zodat we als het goed is geen tv objecten nodig hebben en de tv model import als het goed is overbodig wordt
//todo: class herschrijven voor versimpelde output volgens de opdracht
package com.example.novi_be10_techiteasy.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//todo deze controller doet vooralsnog niks met de model en repository klasse. hier moet vast verandering in komen
//todo voordat ik deze controller ga aanpassen eerst postman apicalls opzetten om responses te testen.

@RestController
@RequestMapping("televisions")//vaste prefix voor requests gerelateerd aan television requests
public class TelevisionControllerBasis {
 //geen properties hier, de methods doen niks, maar returnen alleen een statuscode en eventueel een string

    //get all tv's
    @GetMapping
    public ResponseEntity<String> getTelevisions() {
        return ResponseEntity.ok("televisions!");//return de String met een 200 status
    }

    //get 1 tv
    @GetMapping("/{id}")
    public  ResponseEntity<String> getTelevision(@PathVariable int id) {
        String reqTv = "television number " + id;
        return ResponseEntity.ok(reqTv);
    }

    //post 1
    @PostMapping
    public ResponseEntity<String> createTelevision(@RequestBody String tv){
        return ResponseEntity.created(null).body("new television!" +tv);//deze milde error negeren we even omdat deze response letterlijk uit de opgave komt. returnt 201 created status en de string
    }

    //put 1 tv
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateTelevision(@PathVariable int id ,@RequestBody String televisionData){
        //return 204 status
        return ResponseEntity.noContent().build();
    }

    //delete 1 tv
    @DeleteMapping("/{id}")//deze method delete niks, maar geeft alleen een melding terug
    public ResponseEntity<Void> deleteTelevision(@PathVariable int id){
        return ResponseEntity.noContent().build();//return 204 status en verder niks
    }
}
