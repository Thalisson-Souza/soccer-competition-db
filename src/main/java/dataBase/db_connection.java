package main.java.dataBase;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class db_connection {
    private static final String PROPERTIES_FILE = "db.properties";

    public static Connection getConnection() throws SQLException {
        Properties properties = new Properties();
        try (InputStream input = db_connection.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {
            if (input == null) {
                throw new RuntimeException("Arquivo " + PROPERTIES_FILE + " não encontrado.");
            }
            properties.load(input);

            String url = properties.getProperty("DB_URL");
            String user = properties.getProperty("DB_USER");
            String password = properties.getProperty("DB_PASSWORD");

            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao conectar ao banco de dados: " + e.getMessage(), e);
        }
    }

    public static void main(String[] args) {
        try (Connection connect = getConnection()) {
            if (connect != null) {
                System.out.println("connect sucessful");
            }
        } catch (SQLException e) {
            System.out.println("error" + e.getMessage());
        }
    }
}
