package com.banar.labs.football_players;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface FootballPlayersRepository extends MongoRepository<FootballPlayers, String> {
}