package com.example.demo.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

@RestController
@RequestMapping(path = "/players")
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @GetMapping("/all")
    public ResponseEntity<List<Player>> getAllPlayers(){
        List<Player> players = playerService.getPlayers();
        return new ResponseEntity<>(players, HttpStatus.OK);
    }

    @GetMapping(path = "/{number}")
    public ResponseEntity<Player> getPlayer(@PathVariable int number) {
        Player p = playerService.getPlayer(number);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Player> addPlayer(@RequestBody Player p) {
        Player pl  = playerService.addPlayer(p);
        return new ResponseEntity<>(pl, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Player> updatePlayer(@RequestBody Player p) {
        Player pl = playerService.updatePlayer(p);
        return new ResponseEntity<>(pl, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{number}")
    public ResponseEntity<?> deletePlayer(@PathVariable int number) {
        playerService.deletePlayer(number);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
