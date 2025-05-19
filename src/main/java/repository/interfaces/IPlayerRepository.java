package main.java.repository.interfaces;

import main.java.entity.Player;
import main.java.entity.Team;

import java.sql.SQLException;
import java.util.List;

public interface IPlayerRepository {
    void savePlayer(Player player) throws SQLException;
    void updatePlayer(Player player) throws SQLException;
    void deletePlayer(String name) throws SQLException;
    List<Player> findPlayerByName(String name) throws SQLException;
    List<Player> findPlayersByTeam(Team team) throws SQLException;
}
