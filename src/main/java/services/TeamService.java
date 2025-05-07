package main.java.services;

import main.java.entity.Team;
import main.java.repository.interfaces.ITeamRepository;

import java.sql.SQLException;
import java.util.List;

public class TeamService {
    private ITeamRepository repository;
    private static final int MAX_PLAYERS = 25;

    public TeamService(ITeamRepository repository) {
        this.repository = repository;
    }

    public void addTeam(Team team) throws SQLException {
        if (team.getJogadores().size() > MAX_PLAYERS) {
            throw new IllegalArgumentException("Jogadores cannot have more than 25 jogadores.");
        }
        repository.saveTeam(team);
    }

    public List<Team> listTeam() throws SQLException {
        return repository.findAllTeams();
    }

    public void updateTeam(Team team) throws SQLException {
        if (team.getJogadores().size() > MAX_PLAYERS) {
            throw new IllegalArgumentException("Jogadores cannot have more than 25 jogadores.");
        }
        repository.updateTeam(team);
    }

    public void searchTeam (String name) throws SQLException {
        repository.findTeamByName(name);
    }

    public void deleteTeamById(Long id) throws SQLException {
        repository.deleteById(id);
    }

    public void deleteTeamByName(String name) throws SQLException {
        repository.deleteByName(name);
    }
}
