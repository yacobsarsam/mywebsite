package com.example.mywebsite;

import com.example.mywebsite.Models.Player;
import com.example.mywebsite.Services.Imp.PlayerImp;
import com.example.mywebsite.Services.PlayerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.properties")
public class PlayerControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PlayerService playerService;

    @Autowired
    private PlayerImp playerImp;

    @Test
    public void shouldReturnShowplayers_whenGetRequestPlayers() throws Exception {
        // Lägg till testdata om det behövs
        Player player1 = new Player(1, "Player 1", "24");
        Player player2 = new Player(2, "Player 2", "28");
        playerImp.AddDataToDBIfNotSaved(List.of(player1, player2));

        mockMvc.perform(MockMvcRequestBuilders.get("/players"))
                .andExpect(status().isOk())
                .andExpect(view().name("showplayers"))
                .andExpect(model().attributeExists("playerlist"))
                .andExpect(model().attribute("playerlist", hasSize(2)))
                .andExpect(model().attribute("playerlist", hasItem(
                        allOf(
                                hasProperty("id", is(1)),
                                hasProperty("name", is("Player 1")),
                                hasProperty("old", is("24"))
                        )
                )));
    }
}