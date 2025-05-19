package main.java.repository;

import main.java.entity.Player;
import main.java.entity.Team;
import main.java.repository.interfaces.IPlayerRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlayerRepository implements IPlayerRepository {
    private Connection connect;

    public PlayerRepository(Connection connect) {
        this.connect = connect;
    }

    @Override
    public void savePlayer(Player player) throws SQLException {
        String sql = "INSERT INTO Player (name, position, age, shirtNumber, team_id) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement save = connect.prepareStatement(sql)) {
            save.setString(1, player.getName());
            save.setString(2, player.getPosition());
            save.setInt(3, player.getAge());
            save.setInt(4, player.getShirtNumber());
            save.setLong(5, player.getTeam().getId());
            save.executeUpdate();
        }
    }

    @Override
    public void updatePlayer(Player player) throws SQLException {
        String sql = "UPDATE Player SET name = ?, position = ?, age = ?, shirtNumber = ?, team_id = ? WHERE id = ?";

        try (PreparedStatement update = connect.prepareStatement(sql)) {
            update.setString(1, player.getName());
            update.setString(2, player.getPosition());
            update.setInt(3, player.getAge());
            update.setInt(4, player.getShirtNumber());
            update.setLong(5, player.getTeam().getId());
            update.setLong(6, player.getId());
            update.executeUpdate();
        }
    }

    @Override
    public void deletePlayer(String name) throws SQLException {
        String sql = "DELETE FROM Player WHERE name = ?";
        try (PreparedStatement delete = connect.prepareStatement(sql)) {
            delete.setString(1, name);
            delete.executeUpdate();
        }
    }

    @Override
    public List<Player> findPlayerByName(String name) throws SQLException {
        String sql = "SELECT * FROM Player WHERE name = ?";
        List<Player> players = new ArrayList<>();

        try (PreparedStatement findByName = connect.prepareStatement(sql)) {
            findByName.setString(1, name);
            try (ResultSet rs = findByName.executeQuery()) {
                while (rs.next()) {
                    Player player = new Player();
                    player.setId(rs.getLong("id"));
                    player.setName(rs.getString("name"));
                    player.setPosition(rs.getString("position"));
                    player.setAge(rs.getInt("age"));
                    player.setShirtNumber(rs.getInt("shirtNumber"));

                    Team team = new Team();
                    team.setId(rs.getLong("team_id")); // Relaciona o time pelo ID
                    player.setTeam(team);

                    players.add(player);
                }
            }
        }
        return players;
    }

    @Override
    public List<Player> findPlayersByTeam(Team team) throws SQLException {
        String sql = "SELECT p.*, t.id AS team_id, t.name AS team_name " +
                "FROM Player p " +
                "JOIN Team t ON p.team_id = t.id " +
                "WHERE p.team_id = ?";
        List<Player> players = new ArrayList<>();

        try (PreparedStatement findByTeam = connect.prepareStatement(sql)) {
            findByTeam.setLong(1, team.getId());
            try (ResultSet rs = findByTeam.executeQuery()) {
                while (rs.next()) {
                    Player player = new Player();
                    player.setId(rs.getLong("id"));
                    player.setName(rs.getString("name"));
                    player.setPosition(rs.getString("position"));
                    player.setAge(rs.getInt("age"));
                    player.setShirtNumber(rs.getInt("shirtNumber"));

                    Team associatedTeam = new Team();
                    associatedTeam.setId(rs.getLong("team_id")); // Relaciona o time pelo ID
                    associatedTeam.setName(rs.getString("team_name"));
                    player.setTeam(associatedTeam);

                    players.add(player);
                }
            }
        }
        return players;
    }
}
