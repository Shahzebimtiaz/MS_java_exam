package fr.shahzeb.fund.launcher;

import fr.shahzeb.fund.services.TestJDBC1;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDB3 {

    public static void main(String[] args) {
        // JDBC connection parameters for an in-memory H2 database without username and password
        String url = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1";

        try {
            TestJDBC1.test();
            // Load and run the SQL scripts
            runScript(url, "create-insurances.sql");
            runScript(url, "create-medications.sql");
            runScript(url, "create-prescriptions.sql");

            System.out.println("Database initialized successfully.");

        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    private static void runScript(String url, String scriptFileName) throws IOException, SQLException {
        // Read the SQL script content
        Path scriptPath = Path.of("src/fr/shahzeb/fund/sqlscripts", scriptFileName);
        String scriptContent = Files.readString(scriptPath);

        try (
                // Establish a connection to the database
                Connection connection = DriverManager.getConnection(url);

                // Create a statement
                Statement statement = connection.createStatement()
        ) {
            // Execute the SQL script
            statement.executeUpdate(scriptContent);
            System.out.println("Script " + scriptFileName + " executed successfully.");
        }
    }
}

