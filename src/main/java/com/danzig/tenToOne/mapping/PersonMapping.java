package com.danzig.tenToOne.mapping;

import com.danzig.tenToOne.api.PersonApi;
import com.danzig.tenToOne.model.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonMapping {

    public static PersonApi toPersonApi(Person person) {
        return new PersonApi(person.getFirstName(), person.getLastName());
    }

    public static Person fromPersonApi(PersonApi personApi) {
        return new Person(personApi.getFirstName(), personApi.getLastName());
    }

    public static PersonApi toPersonApiFull(Person person) {
        return new PersonApi(person.getFirstName(), person.getLastName(), person.getId());
    }

    public static List<PersonApi> toPersonApi(List<Person> people) {
        List<PersonApi> peopleApis = new ArrayList<>();
        for(Person person : people) {
            peopleApis.add(toPersonApiFull(person));
        }
        return peopleApis;
    }
}
