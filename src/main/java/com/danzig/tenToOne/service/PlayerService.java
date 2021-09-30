package com.danzig.tenToOne.service;


import com.danzig.tenToOne.model.Person;
import com.danzig.tenToOne.model.Player;
import com.danzig.tenToOne.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {


    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player addPlayer(Player player) {
        Player newPlayer = playerRepository.save(player);
        return newPlayer;
    }

    public void deletePlayer(Player player) {
        playerRepository.delete(player);
    }

    public Player findByPerson(Person person){
       return playerRepository.findPlayerByPerson(person);
    }


    public void deleteAllPlayers() {
        playerRepository.deleteAll();
    }

    public List<Player> getAllPlayers() {
        List<Player> players = playerRepository.findAll();
        return players;
    }
}


