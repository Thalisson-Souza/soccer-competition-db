package test.java.coach;

import main.java.dataBase.db_connection;
import main.java.entity.Coach;
import main.java.repository.CoachRepository;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class CoachCrudTests {
    private Connection getConnection() throws SQLException {
        return db_connection.getConnection();
    }

    private Coach createTestCoach(String name) {
        Coach coach = new Coach();
        coach.setName(name);
        return coach;
    }

    @Test
    public void testSaveCoach() throws SQLException {
        try (Connection connect = getConnection()) {
            CoachRepository repository = new CoachRepository(connect);

            Coach coach = createTestCoach("Luiz");

            repository.saveCoach(coach);
        }
    }

    @Test
    public void testUpdateCoach() throws SQLException {
        try (Connection connect = getConnection()) {
            CoachRepository repository = new CoachRepository(connect);

            Coach coach = createTestCoach("Atualizado");
            coach.setId(1L); // ID de um coach existente no banco

            repository.updateCoach(coach);
        }
    }

    @Test
    public void testFindTeamByName() throws SQLException {
        try (Connection connect = getConnection()) {
            CoachRepository repository = new CoachRepository(connect);

            String searchName = "Luiz";
            Coach coach = repository.findCoachByName(searchName);

            assertNotNull("O Coach não foi encontrado!", coach);

            System.out.println("Coach encontrado:");
            System.out.println("ID: " + coach.getId());
            System.out.println("Nome: " + coach.getName());
        }
    }

    @Test
    public void testDeleteCoachByName() throws SQLException {
        try (Connection connect = getConnection()) {
            CoachRepository repository = new CoachRepository(connect);

            String searchName = "Narco";

            // Verifica se o coach existe antes de excluir
            Coach coach = repository.findCoachByName(searchName);
            assertNotNull("O Coach não foi encontrado antes da exclusão!", coach);

            // Exclui o coach pelo nome
            repository.deleteCoach(searchName);

            // Verifica se o coach foi realmente excluído
            Coach deletedCoach = repository.findCoachByName(searchName);
            assertNull("O Coach não foi excluído corretamente!", deletedCoach);
        }
    }
}