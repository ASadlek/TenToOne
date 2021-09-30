package com.danzig.tenToOne.repository;

import com.danzig.tenToOne.model.Person;
import com.danzig.tenToOne.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    @Query("select p from Player p where p.person = :person")
    public Player findPlayerByPerson(@Param("person") Person person);
}
