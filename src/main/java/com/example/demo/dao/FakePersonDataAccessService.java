package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//class needs to be instantiated as a bean, so we can inject it in other classes
//this named fakeDao allows multiple implementations,
//eg if have postgres or mongo implementation you call it mongo or postgress in the
//string instead of fakedao
@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao{


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
}
