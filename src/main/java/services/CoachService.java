package main.java.services;

import main.java.entity.Coach;
import main.java.repository.interfaces.ICoachRepository;

import java.sql.SQLException;

public class CoachService {
    private ICoachRepository repository;

    public CoachService(ICoachRepository repository) {
        this.repository = repository;
    }

    private void validateCoach(String name) throws SQLException{
        if (name == null || name.isEmpty()) {
            throw new SQLException("Coach name cannot be empty");
        }
    }

    public void SaveCoach(Coach coach) throws SQLException {
        validateCoach(coach.getName());
        repository.saveCoach(coach);
        System.out.println("Treinador foi salvo no banco");
    }

    public void updateCoach(Coach coach) throws SQLException{
        validateCoach(coach.getName());
        repository.updateCoach(coach);
        System.out.println("Treinador foi atualizado no banco");
    }

    public Coach findCoachByName(String name) throws SQLException {
        validateCoach(name);
        Coach coach = repository.findCoachByName(name);
        if (coach == null) {
            throw new SQLException("Coach nao encontrado");
        }
        return coach;
    }

    public void deleteCoach(String name) throws SQLException {
        validateCoach(name);
        repository.deleteCoach(name);
        System.out.println("Treinador foi deletado no banco");
    }
}
