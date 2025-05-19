package test.java.team;

import main.java.dataBase.db_connection;
import main.java.entity.Team;
import main.java.repository.TeamRepository;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class DeleteTeamTest {

    @Test
    public void testDeleteTeamById() throws SQLException {
        try (Connection connect = db_connection.getConnection()) {
            TeamRepository repository = new TeamRepository(connect);

            Long searchId = 2L; // ID do time que você deseja excluir
            Team team = repository.findTeamById(searchId);
            assertNotNull("O time não foi encontrado antes da exclusão!", team);

            repository.deleteById(searchId);

            // Verifica se o time foi realmente excluído
            Team deletedTeam = repository.findTeamById(searchId);
            assertNull("O time não foi excluído corretamente!", deletedTeam);
        }
    }

    @Test
    public void testDeleteTeamByName() throws SQLException {
        try (Connection connect = db_connection.getConnection()) {
            TeamRepository repository = new TeamRepository(connect);

            String searchName = "Internacional"; // Nome do time pra excluir

            // Antes de excluir, verifica se o time existe
            Team team = repository.findTeamByName(searchName);
            assertNotNull("O time não foi encontrado antes da exclusão!", team);

            repository.deleteByName(searchName);

            Team deletedTeam = repository.findTeamByName(searchName);
            assertNull("O time não foi excluído corretamente!", deletedTeam);
        }
    }
}
