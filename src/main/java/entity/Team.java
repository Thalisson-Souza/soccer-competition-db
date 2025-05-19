package main.java.entity;

import java.time.LocalDate;
import java.util.List;

public class Team {

    private Long id;
    private String name;
    private String stadium;
    private String city;
    private LocalDate foundationDate;
    private Coach coach;
    private List<Player> players;

   public Team() {
   }

    public Team(Long id, String name, String stadium, String city, LocalDate foundationDate, Coach coach, List<Player> players) {
        this.id = id;
        this.name = name;
        this.stadium = stadium;
        this.city = city;
        this.foundationDate = foundationDate;
        this.coach = coach;
        this.players = players;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDate getFoundationDate() {
        return foundationDate;
    }

    public void setFoundationDate(LocalDate foundationDate) {
        this.foundationDate = foundationDate;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void add(Team team) {
    }
}
