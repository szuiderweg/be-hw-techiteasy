package com.example.novi_be10_techiteasy.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "televisions")//negeer deze error. komt doordat de database niet in IntelliJ woont
public class Television {
    @Id
    @GeneratedValue
    private long id;
    private String model;
    private double price;
//Uitwerkingen opmerking bij punt 7: Constructors hoeven niet per se aangemaakt te worden. Java maakt automatisch een default constructor (achter de schermen).
//    Let er op dat wanneer je een eigen constructor maakt, bijvoorbeeld een constructor met alle gevraagde variabelen,
//    dan verdwijnt de automatische default constructor. Je moet dan zelf ook een default constructor maken.
//    Je maakt dus nooit 1 constructor. Het is 0 of 2, 3, 4, etc.

//hier gaan we wel zelf constructors maken (want dat staat in de opdracht)

    //default constructor
    public Television() {
    }

    //constructor met alle variabelen. Het id nummer moet mogelijk later eruit gesloopt worden omdat het automatisch gegenereerd moet worden
    public Television(Long id, String model, double price){
        this.id = id;
        this.model = model;
        this.price = price;
    }

    //geen setter voor id, want dat doet de repository al
    public long getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
