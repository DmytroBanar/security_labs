package com.banar.labs.football_players;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/FootballPlayers")
@RequiredArgsConstructor
public class FootballPlayersRestController {

    private final FootballPlayersService footballPlayersService;

    @GetMapping
    public List<FootballPlayers> showAll() {
        return footballPlayersService.getAll();
    }

    @GetMapping("/{id}")
    public FootballPlayers showOneById(@PathVariable String id) {
        return footballPlayersService.getById(id);
    }

    @PostMapping
    public FootballPlayers insert(@RequestBody FootballPlayers FootballPlayers) {
        return footballPlayersService.create(FootballPlayers);
    }

    @PutMapping
    public FootballPlayers edit(@RequestBody FootballPlayers FootballPlayers) {
        return footballPlayersService.update(FootballPlayers);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        footballPlayersService.delById(id);
    }

}