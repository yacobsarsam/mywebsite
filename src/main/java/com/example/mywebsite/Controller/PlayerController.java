package com.example.mywebsite.Controller;

import com.example.mywebsite.Dtos.PlayerDto;
import com.example.mywebsite.Services.PlayerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class PlayerController {
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping(path = "players")
    String MinaProjekt(Model model) {
        List<PlayerDto> allPlayersDto = playerService.getAllPlayersDto();
        for (PlayerDto playerDto : allPlayersDto) {
            System.out.println("MINA " + playerDto.getName());
        }
        model.addAttribute("playerlist", allPlayersDto);

        return "showplayers";
    }
}
