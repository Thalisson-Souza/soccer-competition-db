package main.java.repository.interfaces;

import main.java.entity.Coach;

import java.sql.SQLException;

public interface ICoachRepository {
    void saveCoach(Coach coach) throws SQLException;
    void updateCoach(Coach coach) throws SQLException;
    Coach findCoachByName(String name) throws SQLException;
    void deleteCoach(String name) throws SQLException;
}
