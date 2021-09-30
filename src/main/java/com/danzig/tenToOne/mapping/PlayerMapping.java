package com.danzig.tenToOne.mapping;

import com.danzig.tenToOne.api.PlayerApi;
import com.danzig.tenToOne.model.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerMapping {

    public static PlayerApi toPlayerApi(Player player) {
        return new PlayerApi(3, player.getPerson().getFirstName(), player.getPerson().getLastName(), player.getPerson().getId());
    }

    public static List<PlayerApi> toPlayerApi(List<Player> players) {
        List<PlayerApi> playerApis = new ArrayList<>();
        for(Player player : players) {
            playerApis.add(toPlayerApi(player));
        }
        return playerApis;
    }


}
