package com.example.mywebsite.Services.Imp;



import com.example.mywebsite.Dtos.PlayerDto;
import com.example.mywebsite.Models.Player;
import com.example.mywebsite.Repositories.PlayerRepo;
import com.example.mywebsite.Services.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
@RequiredArgsConstructor
public class PlayerImp implements PlayerService {
    private final PlayerRepo playerRepo;

    @Override
    public PlayerDto PlayerToPlayerDto(Player p) {
        return PlayerDto.builder().id(p.getId()).name(p.getName()).old(p.getOld()).build();
    }

    @Override
    public void AddDataToDBIfNotSaved(List<Player> players) {
List<Player> playersInDatabase = playerRepo.findAll();
        for(Player p: players ){
            Player pToCheck = playersInDatabase.stream().filter(c-> Objects.equals(c.getName(),p.getName())).findFirst().orElse(null);
            if(pToCheck == null){
            playerRepo.save(p);
            }
        }
         //   pr.saveAll(projects);
    }

    @Override
    public List<PlayerDto> getAllPlayersDto() {
        return playerRepo.findAll().stream().map(p -> PlayerToPlayerDto(p)).toList();
    }
}
