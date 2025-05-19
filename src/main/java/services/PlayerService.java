package main.java.services;

import main.java.entity.Player;
import main.java.entity.Team;
import main.java.repository.interfaces.IPlayerRepository;

import java.sql.SQLException;
import java.util.List;

public class PlayerService {
    private IPlayerRepository playerRepository;

    public PlayerService(IPlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public void addPlayer(Player player) throws SQLException {
        playerRepository.savePlayer(player);
    }

    public void updatePlayer(Player player) throws SQLException {
        playerRepository.updatePlayer(player);
    }

    public void deletePlayer(String name) throws SQLException {
        playerRepository.deletePlayer(name);
    }

    public List<Player> findPlayerByName(String name) throws SQLException{
        return playerRepository.findPlayerByName(name);
    }

    public List<Player> findPlayerByTeam(Team team) throws SQLException{
        return playerRepository.findPlayersByTeam(team);
    }

}
