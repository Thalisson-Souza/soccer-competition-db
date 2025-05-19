package main.java.repository.interfaces;

import main.java.entity.Team;

import java.sql.SQLException;
import java.util.List;

public interface ITeamRepository {
    void saveTeam(Team team) throws SQLException;
    List<Team> findAllTeams() throws SQLException;
    Team findTeamById(Long id) throws SQLException;
    Team findTeamByName(String name) throws SQLException;
    void deleteById(Long id) throws SQLException;
    void deleteByName(String name) throws SQLException;
    void updateTeam(Team time) throws SQLException;
}
