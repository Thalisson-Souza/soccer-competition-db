package test.java;

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
        Connection connect = db_connection.getConnection();
        TeamRepository repository = new TeamRepository(connect);

        // Insere um treinador de exemplo
        String insertCoachSQL = "INSERT INTO coach (id, name) VALUES (7, 'Narco')";
        try (PreparedStatement stmt = connect.prepareStatement(insertCoachSQL)) {
            stmt.executeUpdate();
        }

        // Cria uma instância de Coach (certifique-se de que o Coach com ID 1 exista no banco)
        Coach coach = new Coach();
        coach.setId(1L); // Use um ID que existe no banco de dados para o treinador
        coach.setName("Narco");

        // Dados do time a se colocado
        Team team = new Team();
        team.setName("Internacional");
        team.setEstadium("Beira Rio");
        team.setCity("Porto Alegre");
        team.setFoundationDate(LocalDate.of(1909, 4, 4));
        team.setCoach(coach);

        // Salva o time no banco de dados
        repository.saveTeam(team);

        connect.close();
    }
}