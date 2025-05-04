package main.java.entity;

public class Game {

    private long id;
    private int roundNumber;
    private Team homeTeam;
    private Team visitorTeam;
    private int homeTeamGoals;
    private int visitorTeamGoals;

    public Game() {
    }

    public Game(long id, int roundNumber, Team homeTeam, Team visitorTeam, int homeTeamGoals, int visitorTeamGoals) {
        this.id = id;
        this.roundNumber = roundNumber;
        this.homeTeam = homeTeam;
        this.visitorTeam = visitorTeam;
        this.homeTeamGoals = homeTeamGoals;
        this.visitorTeamGoals = visitorTeamGoals;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getVisitorTeam() {
        return visitorTeam;
    }

    public void setVisitorTeam(Team visitorTeam) {
        this.visitorTeam = visitorTeam;
    }

    public int getHomeTeamGoals() {
        return homeTeamGoals;
    }

    public void setHomeTeamGoals(int homeTeamGoals) {
        this.homeTeamGoals = homeTeamGoals;
    }

    public int getVisitorTeamGoals() {
        return visitorTeamGoals;
    }

    public void setVisitorTeamGoals(int visitorTeamGoals) {
        this.visitorTeamGoals = visitorTeamGoals;
    }
}
