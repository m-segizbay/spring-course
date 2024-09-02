package kz.segizbay.springcourse.dao;

import kz.segizbay.springcourse.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private List<Person> people;
    private static int PEOPLE_COUNT;

    {
        people = new ArrayList<Person>();
        people.add(new Person(++PEOPLE_COUNT, "Tom", 24, "tom@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Bob", 52, "bob@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Mike", 18, "mike@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "John", 34, "john@mail.ru"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream()
                .filter(person -> person.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatedPerson) {
        Person persontToUpdate = show(id);
        persontToUpdate.setName(updatedPerson.getName());
        persontToUpdate.setEmail(updatedPerson.getEmail());
        persontToUpdate.setAge(updatedPerson.getAge());
    }

    public void delete(int id) {
        people.removeIf(person -> person.getId() == id);
    }
}
