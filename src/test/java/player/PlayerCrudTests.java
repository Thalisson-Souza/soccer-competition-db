package test.java.player;

import main.java.dataBase.db_connection;
import main.java.entity.Player;
import main.java.entity.Team;
import main.java.repository.PlayerRepository;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PlayerCrudTests {
    private Connection getConnection() throws SQLException {
        return db_connection.getConnection();
    }

    private Player createTestPlayer(String name, String position, int age, int shirtNumber, Long teamId) {
        Team team = new Team();
        team.setId(teamId);

        Player player = new Player();
        player.setName(name);
        player.setPosition(position);
        player.setAge(age);
        player.setShirtNumber(shirtNumber);
        player.setTeam(team);

        return player;
    }

    @Test
    public void testSavePlayer() throws SQLException {
        try (Connection connect = getConnection()) {
            PlayerRepository repository = new PlayerRepository(connect);

            Player player = createTestPlayer("João", "Atacante", 25, 9, 73L);

            repository.savePlayer(player);
        }
    }

    @Test
    public void updatePlayer() throws SQLException {
        try (Connection connect = getConnection()) {
            PlayerRepository repository = new PlayerRepository(connect);

            Player player = createTestPlayer("Mesias", "Zagueiro", 25, 9, 1L);
            player.setId(2L); // ID de um jogador existente no banco

            repository.updatePlayer(player);
        }
    }

    @Test
    public void findPlayersByName() throws SQLException {
        try (Connection connect = getConnection()) {
            PlayerRepository repository = new PlayerRepository(connect);

            String playerName = "Mesias";
            List<Player> players = repository.findPlayerByName(playerName);

            Assert.assertNotNull(players); // A lista não deve ser nula
            Assert.assertFalse(players.isEmpty()); // A lista deve conter jogadores

            // Verifica os jogadores encontrados
            System.out.println("Jogadores encontrados:");
            for (Player player : players) {
                System.out.println("ID: " + player.getId());
                System.out.println("Nome: " + player.getName());
                System.out.println("Posição: " + player.getPosition());
                System.out.println("Idade: " + player.getAge());
                System.out.println("Número da camisa: " + player.getShirtNumber());
                System.out.println("ID do Time: " + player.getTeam().getId());
                Assert.assertEquals(playerName, player.getName());
            }
        }
    }

    @Test
    public void testFindPlayersByName() throws SQLException {
        try (Connection connect = getConnection()) {
            PlayerRepository repository = new PlayerRepository(connect);

            Team team = new Team();
            team.setId(1L); // ID do time existente no banco

            List<Player> players = repository.findPlayersByTeam(team);

            Assert.assertNotNull(players); // A lista não deve ser nula
            Assert.assertFalse(players.isEmpty()); // A lista deve conter jogadores

            // Verifica os jogadores encontrados
            System.out.println("Jogadores do time: " + players.get(0).getTeam().getName() + ":");
            for (Player player : players) {
                System.out.println("Nome: " + player.getName());
                System.out.println("Posição: " + player.getPosition());
                System.out.println("Número da camisa: " + player.getShirtNumber());
                Assert.assertEquals(team.getId(), player.getTeam().getId());
            }
        }
    }
}