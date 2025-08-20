package com.example.mywebsite.DataProviderAsList;

import com.example.mywebsite.Dtos.PlayerDto;
import com.example.mywebsite.Models.Player;
import org.springframework.context.annotation.Bean;

import java.util.List;

public class PlayerDataSeeder {

    @Bean
    public List<Player> getPlayersAsList() {
        PlayerDto player1 = new PlayerDto("Player 1", "Forward");
        PlayerDto player2 = new PlayerDto("Player 2", "Midfielder");
        PlayerDto player3 = new PlayerDto("Player 3", "Defender");

        return List.of(player1, player2, player3);
    }
}