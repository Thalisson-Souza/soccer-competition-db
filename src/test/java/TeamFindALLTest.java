package test.java;

import main.java.dataBase.db_connection;
import main.java.entity.Team;
import main.java.repository.TeamRepository;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class TeamFindALLTest {

    @Test
    public void testListarALL() throws SQLException {
        Connection connect = db_connection.getConnection();
        TeamRepository repository = new TeamRepository(connect);

        List<Team> teams = repository.findAllTeams();

        // Verifica se a lista de times não está vazia
        assertTrue("A lista de times não deve estar vazia", !teams.isEmpty());

        // Você pode adicionar mais verificações dependendo do conteúdo dos times
        System.out.println("Total de times encontrados: " + teams.size());
    }
}
