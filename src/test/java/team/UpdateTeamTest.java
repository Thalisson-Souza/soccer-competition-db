package test.java.team;

import main.java.dataBase.db_connection;
import main.java.entity.Coach;
import main.java.entity.Team;
import main.java.repository.TeamRepository;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class UpdateTeamTest {

    @Test
    public void testUpdateTeam() throws SQLException {
        try(Connection connect = db_connection.getConnection()) {
            TeamRepository repository = new TeamRepository(connect);

            Coach coach = new Coach();
            coach.setId(1L); // ID do treinador existente no BD

            // Dados do time a serem atualizados
            Team team = new Team();
            team.setId(1L); // ID de time existente no BD
            team.setName("Updated para Cleber");
            team.setStadium("Updated Bernabey");
            team.setCity("Updated Sao borja");
            team.setFoundationDate(LocalDate.of(1500, 8, 2));
            team.setCoach(coach);

            repository.updateTeam(team);
        }
    }
}