package kz.segizbay.springcourse.dao;

import kz.segizbay.springcourse.models.Person;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;

    private static final String URL= "jdbc:postgresql://localhost:5432/first_db";
    private static final String USERNAME = "madiyar";
    private static final String PASSWORD = "Madiyar0105";

    private static Connection connection;

    static{
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Person> index() {
        List<Person> persons = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM person";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                Person person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setAge(resultSet.getInt("age"));
                person.setEmail(resultSet.getString("email"));
                persons.add(person);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return persons;
    }

    public Person show(int id) {
//        return people.stream()
//                .filter(person -> person.getId() == id)
//                .findFirst()
//                .orElse(null);
        return null;
    }

    public void save(Person person) {
//        person.setId(++PEOPLE_COUNT);
//        people.add(person);
        try {
            Statement statement = connection.createStatement();
            String SQL = "INSERT INTO person VALUES (" + 1 + ", '" + person.getName()
                    + "', " + person.getAge() + ", '" + person.getEmail() + "')";
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(int id, Person updatedPerson) {
//        Person persontToUpdate = show(id);
//        persontToUpdate.setName(updatedPerson.getName());
//        persontToUpdate.setEmail(updatedPerson.getEmail());
//        persontToUpdate.setAge(updatedPerson.getAge());
    }

    public void delete(int id) {
//        people.removeIf(person -> person.getId() == id);
    }
}
