package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Person {

    private final String name;
    private final UUID id;

//spring needs to know for POST request that the name property in JSON we send to the server
//spring converts the property 'name' in JSON into a java class
    public Person(@JsonProperty("id") UUID id,
                  @JsonProperty("name") String name) {
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
