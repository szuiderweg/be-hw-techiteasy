
//hier maken we nog een controller, maar deze geeft alleen de String returntypes , zodat we als het goed is geen tv objecten nodig hebben en de tv model import als het goed is overbodig wordt
//todo: class herschrijven voor versimpelde output volgens de opdracht
package com.example.novi_be10_techiteasy.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("televisions")//vaste prefix voor requests gerelateerd aan television requests
public class TelevisionControllerStrings {
 //geen properties hier, de methods doen niks, maar returnen alleen een statuscode en eventueel een string

    //get all tv's
    @GetMapping
    public ResponseEntity<String> getTelevisions() {
        return ResponseEntity.ok("televisions!");
    }

    //get 1 tv
    @GetMapping("/{id}")
    public  ResponseEntity<String> getTelevision(@PathVariable long id) {
        String reqTv = "television number " + id;
        return ResponseEntity.ok(reqTv);
    }

    //post 1
    @PostMapping
    public ResponseEntity<String> createTelevision(@RequestBody String tv){
        return ResponseEntity.created(null).body("new television!" +tv);//deze milde error negeren we even omdat deze response letterlijk uit de opgave komt
    }

    //put 1 tv
    @PutMapping("/{id}")
    public ResponseEntity<String> updateTelevision(@PathVariable long id ,@RequestBody String televisionData){
       String updatedTv = "television number " + id +"is updated with "+ televisionData;
       return ResponseEntity.ok(updatedTv);
    }

    //delete 1 tv
    @DeleteMapping()//deze method delete niks, maar geeft alleen een melding terug
    public ResponseEntity<Void> deleteTelevision(){
        return ResponseEntity.noContent().build();
    }
}
//helper is nu overbodig