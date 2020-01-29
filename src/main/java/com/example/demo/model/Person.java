package com.example.demo.model;

import java.util.UUID;

public class Person {

    private final String name;
    private final UUID id;


    public Person(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }
    public String getName() {
        return name;
    }
}
