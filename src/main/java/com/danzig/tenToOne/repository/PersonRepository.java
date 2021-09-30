package com.danzig.tenToOne.repository;

import com.danzig.tenToOne.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("select p from Person p where p.firstName = :firstName and p.lastName = :lastName")
    public Person findPersonByFirstAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);
}
