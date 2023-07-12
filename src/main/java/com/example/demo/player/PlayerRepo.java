package com.example.demo.player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepo extends JpaRepository<Player, Integer> {
    void deletePlayerByJerseyNumber(int number);

    Optional<Player> findPlayerByJerseyNumber(int number);

    List<Player> getByOrderByJerseyNumber();
}
