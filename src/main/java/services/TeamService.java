package main.java.services;

import main.java.entity.Team;
import main.java.repository.TeamRepository;

import java.sql.SQLException;
import java.util.List;

public class TeamService {
    private TeamRepository repository;
    private static final int MAX_PLAYERS = 25;

    public TeamService(TeamRepository repository) {
        this.repository = repository;
    }

    public void addTeam(Team team) throws SQLException {
        if (team.getJogadores().size() > MAX_PLAYERS){
            throw new IllegalArgumentException("Jogadores cannot have more than 25 jogadores.");
        }
        repository.saveTeam(team);
    }

    public List<Team> listTeam() throws SQLException {
        return repository.findAllTeams();
    }
}
