package test.java;

import main.java.dataBase.db_connection;
import main.java.entity.Coach;
import main.java.entity.Team;
import main.java.repository.TeamRepository;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class TeamSaveTest {

    @Test
    public void testSaveTeam() throws SQLException {
        // Obtém a conexão diretamente no teste
        Connection connect = db_connection.getConnection();
        TeamRepository repository = new TeamRepository(connect);

        // Cria uma instância de Coach (certifique-se de que o Coach com ID 1 exista no banco)
        Coach coach = new Coach();
        coach.setId(1L); // Use um ID que existe no banco de dados para o treinador

        // Cria uma instância de Team
        Team team = new Team();
        team.setName("Team Save Test");
        team.setEstadium("Test Stadium");
        team.setCity("Test City");
        team.setFoundationDate(LocalDate.of(2000, 1, 1));
        team.setCoach(coach);

        // Salva o time no banco de dados
        repository.saveTeam(team);

        // Fecha a conexão
        connect.close();
    }
}
