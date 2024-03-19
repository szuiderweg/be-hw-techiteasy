package com.example.novi_be10_techiteasy.models;
//dit is een placeholder class om de controller class soort van werkend te krijgen
//het bestaat alleen uit een naam en een id-nummer
public class Television {
    private long id;
    private String model;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
