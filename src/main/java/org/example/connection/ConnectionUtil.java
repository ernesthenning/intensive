package org.example.connection;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionUtil {
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        return PostgreSQLConnection.getPostgreSQLConnection();
    }

    public static void closeQuietly(Connection conn) {
        try {
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void rollbackQuietly(Connection conn) {
        try {
            conn.rollback();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
