//In deze controller worden televisie objecten gemaakt en bewerkt, maar dat is helaas niet volgens de opdracht
package com.example.novi_be10_techiteasy.controllers;

import com.example.novi_be10_techiteasy.models.Television;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("eigentelevisions")//vaste prefix voor requests gerelateerd aan television requests
public class TelevisionControllerEigenUitwerking {
    //laten we de lesopdracht over auto's een beetje imiteren door hier een list van tv's te maken

    private Long currentId = 1L;//teller die het huidige beschikbare id-nummer bijhoudt en toewijst aan een nieuwe tv
    private final List<Television> tvList = new ArrayList<>();

    //get all tv's
    @GetMapping
    public ResponseEntity<List<Television>> getTelevisions() {
        return ResponseEntity.ok(tvList);
    }

    //get 1 tv
    @GetMapping("/{id}")
    public  ResponseEntity<Television> getTelevision(@PathVariable long id){
       Television reqTv = findTvById(id);
       if(reqTv == null){
        return ResponseEntity.notFound().build();
        }
       return ResponseEntity.ok(reqTv);
    }

    //post 1
    @PostMapping
    public ResponseEntity<Television> createTelevision(@RequestBody Television tv){
        tv.setId(currentId++);
        tvList.add(tv);
        return ResponseEntity.status(HttpStatus.CREATED).body(tv);//
    }

    //put 1 tv
    @PutMapping("/{id}")
    public ResponseEntity<Television> updateTelevision(@PathVariable long id ,@RequestBody Television television){
        Television reqTv = findTvById(id);
        if(reqTv == null){
            return ResponseEntity.notFound().build();
        }
        television.setModel(television.getModel());
        return ResponseEntity.ok(television);
    }

    //delete 1 tv
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTelevision(@PathVariable long id){
       Television reqTv = findTvById(id);
        if(reqTv == null){
            return ResponseEntity.notFound().build();
        }
        tvList.remove(reqTv);
        return ResponseEntity.noContent().build();
    }

    private Television findTvById(Long id) {
        for (Television tv : tvList) {
            if (tv.getId() == id){
                return tv;
            }
        }
        return null;
    }
}
//die helper is echt wel nodig, want ik gebruik hem hier al 3 keer. Deze helper vervangt de zoek functie die anders in de repository zou zitten.