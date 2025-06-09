package com.myspringboot.test.TAnimalShelter.entity;

public class Animal {

    private String name;

    public Animal() {
        this.name = "Unknown Animal";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
