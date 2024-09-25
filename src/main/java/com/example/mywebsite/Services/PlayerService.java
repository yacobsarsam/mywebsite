package com.example.mywebsite.Services;


import com.example.mywebsite.Dtos.PlayerDto;
import com.example.mywebsite.Models.Player;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface PlayerService {
    public PlayerDto PlayerToPlayerDto(Player player);
    //public Project getProjectDetailsById(int id);
    public void AddDataToDBIfNotSaved(List<Player> players);

    List<PlayerDto> getAllPlayersDto();
}
