package main.java.entity;

import java.time.LocalDate;
import java.util.List;

public class Team {

    private long id;
    private String name;
    private String estadium;
    private String city;
    private LocalDate foundationDate;
    private Coach coach;
    private List<Player> jogadores;

   public Team() {
   }

    public Team(long id, String name, String estadium, String city, LocalDate foundationDate, Coach coach, List<Player> jogadores) {
        this.id = id;
        this.name = name;
        this.estadium = estadium;
        this.city = city;
        this.foundationDate = foundationDate;
        this.coach = coach;
        this.jogadores = jogadores;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEstadium() {
        return estadium;
    }

    public void setEstadium(String estadium) {
        this.estadium = estadium;
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

    public List<Player> getJogadores() {
        return jogadores;
    }

    public void setJogadores(List<Player> jogadores) {
        this.jogadores = jogadores;
    }

    public void add(Team team) {
    }
}
