package com.example.mywebsite.Services;


import com.example.mywebsite.Dtos.PlayerDto;
import com.example.mywebsite.Models.Player;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlayerService {
    PlayerDto PlayerToPlayerDto(Player player);

    void AddDataToDBIfNotSaved(List<Player> players);

    List<PlayerDto> getAllPlayersDto();
}
