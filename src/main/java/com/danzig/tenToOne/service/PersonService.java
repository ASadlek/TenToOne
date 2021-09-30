package com.danzig.tenToOne.service;

import com.danzig.tenToOne.model.Person;
import com.danzig.tenToOne.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    public List<Person> getAllPeople() {
        List<Person> people = personRepository.findAll();
        return people;
    }

    public Person addPerson(Person person) {
        Person newPerson = personRepository.save(person);
        return newPerson;
    }

    public Optional<Person> personById (Long id) {
        return personRepository.findById(id);
    }

    public Person personByName (String firstName, String lastname) {
        return personRepository.findPersonByFirstAndLastName(firstName, lastname);
    }
}
