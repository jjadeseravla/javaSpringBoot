package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

//class needs to be instantiated as a bean, so we can inject it in other classes
//this named fakeDao allows multiple implementations,
//eg if have postgres or mongo implementation you call it mongo or postgress in the
//string instead of fakedao
@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao{
//cntl enter on implements word imports the methods you wrote on
// persondao interface

    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }

    @Override
    //scan DB to see if a person has this id
    public Optional<Person> selectPersonById(UUID id) {
        return DB.stream()
                 .filter(person -> person.getId().equals(id))
                 .findFirst();
    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<Person> personMaybe = selectPersonById(id);
        if (personMaybe.isEmpty()) {
            return 0;
        }
        DB.remove(personMaybe.get());
            return 1;
    }

    //find person by id and find its index. if it is index 0 or higher, it exists in DB
    // So replace it with id and person or what new person to replace them that you passed in
    //as parameters to updatePersonById() method.
    //if you cant do this return 0, or if you cant find the id return 0
    @Override
    public int updatePersonById(UUID id, Person update) {
        return selectPersonById(id)
                .map(person -> {
                    int indexOfPersonToUpdate = DB.indexOf(person);
                    if (indexOfPersonToUpdate >= 0) {
                        DB.set(indexOfPersonToUpdate, new Person(id, update.getName()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
