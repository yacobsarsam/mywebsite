package com.example.mywebsite;

import com.example.mywebsite.Models.Player;
import com.example.mywebsite.Services.Imp.PlayerImp;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.util.List;

@Component
@Profile("!test")
@RequiredArgsConstructor
public class DataSeederDataBase implements CommandLineRunner {
    private final PlayerImp pImp;

    @Override
    public void run(String... args) throws Exception {

        pImp.AddDataToDBIfNotSaved(CreatePlayerData());

    }

    @Bean
    private  List<Player> CreatePlayerData() throws MalformedURLException {
        Player p1 = new Player(1, "Anders Ohlsonn","30");
        Player p2 = new Player(2,"Gustav Anderson","32");
        Player p3 = new Player(3,"Jakob Berggren","34");

        return List.of(p1, p2, p3);
    }

}
