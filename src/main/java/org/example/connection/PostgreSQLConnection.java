package org.example.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreSQLConnection {
    public static Connection getPostgreSQLConnection() throws ClassNotFoundException, SQLException {
        String connectionURL = "jdbc:postgresql://localhost:5432/postgres";
        String userName = "postgres";
        String password = "password";
        return getPostgreSQLConnection(connectionURL, userName, password);
    }

    public static Connection getPostgreSQLConnection(String connectionURL,
                                                     String userName, String password) throws SQLException, ClassNotFoundException {

        return DriverManager.getConnection(connectionURL, userName, password);
    }
}
