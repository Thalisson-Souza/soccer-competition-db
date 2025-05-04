package main.java.repository;

import main.java.entity.Team;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeamRepository {
    private Connection connect;

    public TeamRepository(Connection connect) {
        this.connect = connect;
    }

    public void saveTeam(Team time) throws SQLException {
        String sql = "INSERT INTO Team (name, stadium, city, foundation_date, coach_id) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement save = connect.prepareStatement(sql);) {
            save.setString(1, time.getName());
            save.setString(2, time.getEstadium());
            save.setString(3, time.getCity());
            save.setDate(4, java.sql.Date.valueOf(time.getFoundationDate()));
            save.setLong(5, time.getCoach().getId());
            save.executeUpdate();
        }
    }

    public List<Team> findAllTeams() throws SQLException {
        String sql = "SELECT * FROM Team";

        try (Statement stmt = connect.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            List<Team> teams = new ArrayList<>();
            while (rs.next()) {
                Team team = new Team();
                team.setId(rs.getLong("id"));
                team.setName(rs.getString("name"));
                team.setEstadium(rs.getString("stadium"));
                team.setCity(rs.getString("city"));
                team.setFoundationDate(rs.getDate("foundation_date").toLocalDate());
                teams.add(team);
            }
            return teams;
        }
    }
}
