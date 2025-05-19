package test.java.team;

import main.java.dataBase.db_connection;
import main.java.entity.Team;
import main.java.repository.TeamRepository;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.assertNotNull;

public class BuscaTeamTest {

    @Test
    public void testFindTeamByName() throws SQLException {
        try (Connection connect = db_connection.getConnection()) {
            TeamRepository repository = new TeamRepository(connect);

            String searchName = "Internacional";

            Team team = repository.findTeamByName(searchName);

            assertNotNull("O time não foi encontrado!", team); // Verifica se o time não é null

            System.out.println("Time encontrado:");
            System.out.println("ID: " + team.getId());
            System.out.println("Nome: " + team.getName());
            System.out.println("Estádio: " + team.getStadium());
            System.out.println("Cidade: " + team.getCity());

            // Exibe os dados do treinador
            if (team.getCoach() != null) {
                System.out.println("Treinador encontrado:");
                System.out.println("ID: " + team.getCoach().getId());
                System.out.println("Nome: " + team.getCoach().getName());
            } else {
                System.out.println("Nenhum treinador associado a este time.");
            }
        }
    }
}