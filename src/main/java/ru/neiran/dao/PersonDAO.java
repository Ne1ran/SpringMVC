package ru.neiran.dao;

import org.springframework.stereotype.Component;
import ru.neiran.models.Person;

import java.util.ArrayList;

@Component
public class PersonDAO {
    private ArrayList<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(1, "Bob"));
        people.add(new Person(2, "Tom"));
        people.add(new Person(3, "Mike"));
        people.add(new Person(4, "Valera"));
    }

    public ArrayList<Person> index(){
        return people;
    }

    public Person show(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }
}
