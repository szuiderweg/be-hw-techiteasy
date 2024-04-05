package com.example.novi_be10_techiteasy.repository;

import com.example.novi_be10_techiteasy.models.Television;
import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.List;
//import java.util.Optional;

public interface TelevisionRepository extends JpaRepository<Television, Long>{
//   //fancy custom method: zoek lijst van tv's op prijs (zelf verzonnen)
//    //todo deze query(?) verder uitwerken in de andere lagen, deze wordt verder (nog) nergens gebruikt
//    Optional<List<Television>> findByPriceBetween(double minPrice, double maxPrice);

}
