package main.java.repository;

import main.java.entity.Coach;
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

        try (PreparedStatement save = connect.prepareStatement(sql)) {
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

    public Team updateTeam(Team time) throws SQLException {
        String sql = "UPDATE Team SET name = ?, stadium = ?, city = ?, foundation_date = ?, coach_id = ? WHERE id = ?";

        try (PreparedStatement update = connect.prepareStatement(sql)) {
            update.setString(1, time.getName());
            update.setString(2, time.getEstadium());
            update.setString(3, time.getCity());
            update.setDate(4, java.sql.Date.valueOf(time.getFoundationDate()));
            update.setLong(5, time.getCoach().getId());
            update.setLong(6, time.getId());

            int linhasAfetadas = update.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Time atualizado com sucesso!");
            }else {
                System.out.println("Não encontrei time pelo ID dado");
            }
            return time;
        }


    }

    public Team findTeamById(Long id) throws SQLException {
        String sql = "SELECT t.id, t.name, t.stadium, t.city, t.foundation_date, c.id as coach_id, c.name as coach_name " +
                "FROM Team t " +
                "LEFT JOIN Coach c ON t.coach_id = c.id " +
                "WHERE t.id = ?";


        try (PreparedStatement find = connect.prepareStatement(sql)) {
            find.setLong(1, id);

            try (ResultSet rs = find.executeQuery()) {
                if (rs.next()) {
                    Team team = new Team();
                    team.setId(rs.getLong("id"));
                    team.setName(rs.getString("name"));
                    team.setEstadium(rs.getString("stadium"));
                    team.setCity(rs.getString("city"));
                    team.setFoundationDate(rs.getDate("foundation_date").toLocalDate());

                    Coach coach = new Coach();
                    coach.setId(rs.getLong("coach_id"));
                    coach.setName(rs.getString("name"));
                    team.setCoach(coach);

                    return team;
                }else{
                    return null;
                }
            }
        }
    }

    public void deleteById(Long id) throws SQLException{
        String sql = "DELETE FROM Team WHERE id = ?";

        try (PreparedStatement delete = connect.prepareStatement(sql)) {
            delete.setLong(1, id);

            int rows = delete.executeUpdate();
            if (rows > 0) {
                System.out.println("Time deletado com sucesso!");
            } else {
                System.out.println("Não encontrado o ID dado");
            }
        }
    }
}
