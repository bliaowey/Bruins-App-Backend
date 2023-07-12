package com.example.demo.player;

import com.example.demo.exception.PlayerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;


@Service
public class PlayerService {

    private final PlayerRepo playerRepo;
    @Autowired
    public PlayerService(PlayerRepo playerRepo) {
        this.playerRepo = playerRepo;
    }

    public List<Player> getPlayers() {
        return playerRepo.getByOrderByJerseyNumber();
    }

    public Player getPlayer(int number) {
        return playerRepo.findPlayerByJerseyNumber(number)
                .orElseThrow(() -> new PlayerNotFoundException("There is no player on the roster who wears jersey number" + number));
    }

    public Player addPlayer(Player p) {
        return playerRepo.save(p);
    }

    public Player updatePlayer(Player p) {
        return playerRepo.save(p);
    }

    public void deletePlayer(int number) {
        playerRepo.deletePlayerByJerseyNumber(number);
    }
}
