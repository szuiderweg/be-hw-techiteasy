package com.example.novi_be10_techiteasy.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "televisions")
public class Television {
    @Id
    @GeneratedValue
    private long id;
    private String model;
    private double price;

}
