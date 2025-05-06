package test.java;

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
    public void testDeleteTeam() throws SQLException {
        Connection connect = db_connection.getConnection();
        TeamRepository repository = new TeamRepository(connect);

        Long existsId = 1L; // ID do time que você deseja excluir

        // Antes de excluir, verifica se o time existe
        Team team = repository.findTeamById(existsId);
        assertNotNull("O time não foi encontrado antes da exclusão!", team);

        // Exclui o time
        repository.deleteById(existsId);

        // Verifica se o time foi realmente excluído
        Team deletedTeam = repository.findTeamById(existsId);
        assertNull("O time não foi excluído corretamente!", deletedTeam); // Espera que seja nulo

        connect.close();
    }
}
