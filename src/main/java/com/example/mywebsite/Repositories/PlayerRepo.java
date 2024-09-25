package com.example.mywebsite.Repositories;

import com.example.mywebsite.Models.Player;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository
public interface PlayerRepo extends JpaRepository<Player,Long> {
}
