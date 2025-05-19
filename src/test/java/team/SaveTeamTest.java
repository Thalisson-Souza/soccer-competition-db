package test.java.team;

import main.java.dataBase.db_connection;
import main.java.entity.Coach;
import main.java.entity.Team;
import main.java.repository.TeamRepository;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class SaveTeamTest {

    @Test
    public void testSaveTeam() throws SQLException {
        try(Connection connect = db_connection.getConnection()) {
            TeamRepository repository = new TeamRepository(connect);

            // Cria uma instância de Coach (Coach com ID 1 exista no banco)
            Coach coach = new Coach();
            coach.setId(2L); // ID que existe no banco de dados para o treinador
            coach.setName("Maico");

            // Dados do time a se colocado
            Team team = new Team();
            team.setName("Internacional");
            team.setStadium("Beira Rio");
            team.setCity("Porto Alegre");
            team.setFoundationDate(LocalDate.of(1909, 4, 4));
            team.setCoach(coach);

            repository.saveTeam(team);
        }
    }
}