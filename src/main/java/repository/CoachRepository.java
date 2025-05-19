package main.java.repository;

import main.java.entity.Coach;
import main.java.repository.interfaces.ICoachRepository;

import java.sql.*;

public class CoachRepository implements ICoachRepository {
    private Connection connect;

    public CoachRepository(Connection connect) {
        this.connect = connect;
    }

    @Override
    public void saveCoach(Coach coach) throws SQLException {
        String sql = "INSERT INTO coach (name) VALUES (?)";

        try (PreparedStatement ps = connect.prepareStatement(sql)) {
            ps.setString(1, coach.getName());
            ps.executeUpdate();
        }
    }

    @Override
    public void updateCoach(Coach coach) throws SQLException {
        String sql = "UPDATE coach SET name = ? WHERE id = ?";

        try (PreparedStatement ps = connect.prepareStatement(sql)) {
            ps.setString(1, coach.getName());
            ps.setLong(2, coach.getId());
        }
    }

    @Override
    public Coach findCoachByName(String name) throws SQLException {
        String sql = "SELECT * FROM coach WHERE name = ?";

        try (PreparedStatement ps = connect.prepareStatement(sql)) {
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Coach coach = new Coach();
                coach.setId(rs.getLong("id"));
                coach.setName(rs.getString("name"));

                return coach;
            } else {
                return null;
            }
        }
    }

    @Override
    public void deleteCoach(String name) throws SQLException {
        String sql = "DELETE FROM coach WHERE name = ?";
        try (PreparedStatement delete = connect.prepareStatement(sql)) {
            delete.setString(1, name);
            delete.executeUpdate();
        }
    }


}
