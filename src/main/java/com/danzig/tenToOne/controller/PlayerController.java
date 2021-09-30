package com.danzig.tenToOne.controller;


import com.danzig.tenToOne.api.PlayerApi;
import com.danzig.tenToOne.api.StreamApi;
import com.danzig.tenToOne.mapping.PlayerMapping;
import com.danzig.tenToOne.model.Person;
import com.danzig.tenToOne.model.Player;
import com.danzig.tenToOne.service.PersonService;
import com.danzig.tenToOne.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "game/player")
public class PlayerController {

    private final PlayerService playerService;

    private final PersonService personService;

    @Autowired
    public PlayerController(PlayerService playerService, PersonService personService) {
        this.playerService = playerService;
        this.personService = personService;
    }


    @GetMapping("/add/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void addPlayer(@PathVariable("id") Long id) {
        Optional<Person> newPerson = personService.personById(id);
        Player player = new Player(3, newPerson.get());
        playerService.addPlayer(player);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePlayer(@PathVariable("id") Long id) {
        Optional<Person> person = personService.personById(id);
        Player player = playerService.findByPerson(person.get());
        playerService.deletePlayer(player);
    }

    @DeleteMapping("/delete/all")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAllPlayers() {

        playerService.deleteAllPlayers();
    }

    @GetMapping("/all")
    public List<PlayerApi> getAllPlayers() {
        List<Player> allPlayersNormal = playerService.getAllPlayers();
        List<PlayerApi> allPlayers = PlayerMapping.toPlayerApi(allPlayersNormal);
        return allPlayers;
    }

    @GetMapping("/stream/{id}")
    public StreamApi getStream(@PathVariable("id") Long id) {
            return new StreamApi(id);
    }



}
