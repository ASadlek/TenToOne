package com.danzig.tenToOne.controller;

import com.danzig.tenToOne.api.PersonApi;
import com.danzig.tenToOne.mapping.PersonMapping;
import com.danzig.tenToOne.model.Person;
import com.danzig.tenToOne.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "game/person")
public class PersonController {

    private final PersonService personService;

    @Autowired
        public PersonController(PersonService personService) {
        this.personService = personService;
    }


    @GetMapping("/all")
    public List<PersonApi> getAllPeople() {
        List<Person> normalList = personService.getAllPeople();
        List<PersonApi> apiList = PersonMapping.toPersonApi(normalList);
        return apiList;
    }

    @GetMapping("/{id}")
    public Optional<Person> getPersonById(@PathVariable("id") Long id){
        return personService.personById(id);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Person registerPerson(@RequestBody Person person) {
        Person newPerson = personService.addPerson(person);
        return newPerson;
    }




}
