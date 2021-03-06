package com.example.demo.api;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;
//like your node app express app file.  shows you endpoints

//give it the url you want to POST to be on
//this is your first endpoint with springboot
//restcontroller class where we can expose some methods (get, post etc)
//that clients can consume
@RequestMapping("api/v1/person")
@RestController
public class PersonController {

    private final PersonService personService;

    @Autowired
    //springboot injects the service into this constructor
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    //to tell spring this method will be used as a POST request
    @PostMapping
    //want to take requestbody and put it inside this person
    public void addPerson(@RequestBody @Valid @NotNull Person person) {
        personService.addPerson(person);
    }

    //this method served as a GET request
    @GetMapping
    public List<Person> getAllPeople() {
        return personService.getAllPeople();
    }

    //pathvariable is how to get id from path to put in the url when doing the GET
    //want the id in the path.  turning path id into a UUID type
    @GetMapping(path = "{id}")
    public Person getPersonById(@PathVariable("id") UUID id) {
        return personService.getPersonById(id)
                             .orElse(null);
    }

    //delete resourse from the server
    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") UUID id) {
        personService.deletePerson(id);
    }

    @PutMapping(path = "{id}")
    public void updatePersonById(@PathVariable("id") UUID id, @Valid @NotNull @RequestBody Person personToUpdate) {
        personService.updatePersonById(id, personToUpdate);
    }

}
