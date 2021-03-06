package se.ecutb.data;

import org.springframework.stereotype.Component;
import se.ecutb.model.Address;
import se.ecutb.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class Personimplementation implements PersonRepository {
    private List<Person> people = new ArrayList<>();
    @Override
    public Optional<Person> findById(int personId) {
        return people.stream().filter(person -> person.getPersonId() == personId).findFirst();

    }

    @Override
    public Person persist(Person person) throws IllegalArgumentException {
        if(people.contains(person.getPersonId())||
                people.toString().contains(person.getFirstName())||
                people.toString().contains(person.getLastName())||
                people.toString().contains(person.getEmail()))
        {
            throw new IllegalArgumentException();
        }else {
            people.add(person);
        }
        return person;
    }

    @Override
    public Optional<Person> findByEmail(String email) throws IllegalArgumentException{
        return people.stream()
                .filter(person -> person.getEmail().equals(email)).findFirst();
    }

    @Override
    public List<Person> findByAddress(Address address) {
        return people.stream().filter(person -> person.getAddress().equals(address)).collect(Collectors.toList());
    }

    @Override
    public List<Person> findByCity(String city) {
        return people.stream().filter(person -> person.getAddress().getCity().equals(city)).collect(Collectors.toList());
    }

    @Override
    public List<Person> findByLastName(String lastName) {
        return people.stream().filter(person -> person.getLastName().equalsIgnoreCase(lastName)).collect(Collectors.toList());
    }

    @Override
    public List<Person> findByFullName(String fullName) {
        return people.stream().filter(person -> (person.getFirstName() + " " + person.getLastName())
                .equalsIgnoreCase(fullName)).collect(Collectors.toList());
    }

    @Override
    public List<Person> findAll() {
        return people;
    }

    @Override
    public boolean delete(int personId) throws IllegalArgumentException {
        return people.remove(findById(personId).orElseThrow(IllegalArgumentException::new));
    }

    @Override
    public void clear() {

        people.clear();
    }
}
