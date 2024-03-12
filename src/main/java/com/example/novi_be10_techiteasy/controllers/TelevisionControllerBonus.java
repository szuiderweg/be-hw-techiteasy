//In deze controller worden televisie objecten gemaakt en bewerkt, maar dat is helaas niet volgens de opdracht
package com.example.novi_be10_techiteasy.controllers;

import com.example.novi_be10_techiteasy.models.Television;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/bonustelevisions")//vaste prefix voor requests gerelateerd aan television requests
public class TelevisionControllerBonus {
    //laten we de lesopdracht over auto's een beetje imiteren door hier een list van tv's te maken
    //de list is static omdat er maar 1 lijst kan zijn, geen meerdere instances van deze lijst
    // de lijst is final omdat de lisjt op zich verandert niet, alleen de waarden die erin staan
    private static final List <String> tvList = new ArrayList<>();

    //get all tv's
    @GetMapping
    public ResponseEntity<List<String>> getTelevisions() {
        return ResponseEntity.ok(tvList);//return complete list of tv-strings met 200 status
    }

    //get 1 tv
    @GetMapping("/{id}")
    public  ResponseEntity<String> getTelevision(@PathVariable long id){
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
//die helper is echt wel nodig, want ik gebruik hem hier al 3 keer.