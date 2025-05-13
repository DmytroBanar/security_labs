package com.banar.labs.football_players;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Document
public class FootballPlayers extends AuditMetaData {
    private String id;
    private String name;
    private String surname;
    private int number;
    private int age;
    private String league;
    private String team;
    private String country;
    private String position;


    public FootballPlayers(String name, String surname, int number, int age, String league, String team, String country, String position) {
        this.name = name;
        this.surname = surname;
        this.number = number;
        this.age = age;
        this.league = league;
        this.team = team;
        this.country = country;
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FootballPlayers dish = (FootballPlayers) o;
        return Objects.equals(id, dish.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}