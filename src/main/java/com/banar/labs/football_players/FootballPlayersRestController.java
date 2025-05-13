package com.banar.labs.football_players;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/FootballPlayers")
@RequiredArgsConstructor
public class FootballPlayersRestController {

    private final FootballPlayersService footballPlayersService;

    @GetMapping
    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN')")
    public List<FootballPlayers> showAll() {
        return footballPlayersService.getAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN')")
    public FootballPlayers showOneById(@PathVariable String id) {
        return footballPlayersService.getById(id);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'SUPERADMIN')")
    public FootballPlayers insert(@RequestBody FootballPlayers FootballPlayers) {
        return footballPlayersService.create(FootballPlayers);
    }

    @PutMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'SUPERADMIN')")
    public FootballPlayers edit(@RequestBody FootballPlayers FootballPlayers) {
        return footballPlayersService.update(FootballPlayers);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPERADMIN')")
    public void delete(@PathVariable String id) {
        footballPlayersService.delById(id);
    }

    @GetMapping("/age/{minAge}/{maxAge}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN')")
    public List<FootballPlayers> getByAgeRange(@PathVariable int minAge, @PathVariable int maxAge) {
        return footballPlayersService.getByAgeRange(minAge, maxAge);
    }

    @GetMapping("/team/{team}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN')")
    public List<FootballPlayers> getByTeam(@PathVariable String team) {
        return footballPlayersService.getByTeam(team);
    }

    @GetMapping("/country/{country}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN')")
    public List<FootballPlayers> getByCountry(@PathVariable String country) {
        return footballPlayersService.getByCountry(country);
    }
}