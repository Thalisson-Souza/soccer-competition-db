package test.java;

import main.java.dataBase.db_connection;
import main.java.entity.Team;
import main.java.repository.TeamRepository;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TeamBuscaTest {

    @Test
    public void testFindTeamById() throws SQLException {
        Connection connect = db_connection.getConnection();
        TeamRepository repository = new TeamRepository(connect);

        Long existsId = 1L;

        Team team = repository.findTeamById(existsId);

        // Validações
        assertNotNull("O time não foi encontrado!", team); // Verifica se o time não é nulo
        assertEquals(existsId.longValue(), team.getId()); // Verifica se o ID está correto

        // Exibe os dados do time encontrado para inspeção
        System.out.println("Time encontrado:");
        System.out.println("ID: " + team.getId());
        System.out.println("Nome: " + team.getName());
        System.out.println("Estádio: " + team.getEstadium());
        System.out.println("Cidade: " + team.getCity());

        // Valida os atributos do time (substitua pelos valores reais do banco de dados)
        assertEquals("Updated para Cleber", team.getName());
        assertEquals("Updated Bernabey", team.getEstadium());
        assertEquals("Updated Sao borja", team.getCity());

        // Valida os atributos do treinador associado, se houver
        assertNotNull("O treinador não foi encontrado!", team.getCoach());
        assertEquals(Long.valueOf(1L), Long.valueOf(team.getCoach().getId())); // Verifica o ID do treinador
        assertEquals("Updated para Cleber", team.getCoach().getName()); // Nome esperado do treinador

        // Exibe os dados do treinador encontrado para inspeção
        System.out.println("Treinador encontrado:");
        System.out.println("ID: " + team.getCoach().getId());
        System.out.println("Nome: " + team.getCoach().getName());

        connect.close();
    }
}
