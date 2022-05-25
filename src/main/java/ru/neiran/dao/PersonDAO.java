package ru.neiran.dao;

import org.springframework.stereotype.Component;
import ru.neiran.models.Person;

import java.util.ArrayList;

@Component
public class PersonDAO {
    private ArrayList<Person> people;
    private static int PEOPLE_COUNT;
    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Bob", 23, "bob@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Tom", 44, "ttttom@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Mike", 32, "ikem@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Valera", 18, "rsarsa@mail.ru"));
    }

    public ArrayList<Person> index(){
        return people;
    }

    public Person show(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person){
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatedPerson){
        Person personToBeUpdated = show(id);

        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id){
        people.removeIf(p -> p.getId() == id);
    }
}














