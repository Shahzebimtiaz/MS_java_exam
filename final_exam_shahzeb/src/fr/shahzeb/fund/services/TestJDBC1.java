package fr.shahzeb.fund.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDBC1 {

    public static void test() {
        // Database connection parameters for in-memory H2 database
        String jdbcUrl = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1";

        try (
                // Establishing a connection to the database
                Connection connection = DriverManager.getConnection(jdbcUrl);

                // Creating a statement
                Statement statement = connection.createStatement()
        ) {
            // SQL statement to create the PATIENTS table with an auto-incrementing "id" column
            String createTableSQL = "CREATE TABLE IF NOT EXISTS PATIENTS (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "pat_num_HC VARCHAR(255) NOT NULL," +
                    "pat_lastname VARCHAR(255) NOT NULL," +
                    "pat_firstname VARCHAR(255) NOT NULL," +
                    "pat_address VARCHAR(255)," +
                    "pat_tel VARCHAR(20)," +
                    "pat_insurance_id INT," +
                    "pat_subscription_date DATE" +
                    ")";

            // Executing the SQL statement
            statement.execute(createTableSQL);

            System.out.println("Table PATIENTS created successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}




