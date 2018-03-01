package sample.database;

import java.sql.*;

/**
 * Created by Marcin on 13.02.2018.
 */
public class DBConnection {

    private static final String DEFAULT_DRIVER_CLASS = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String DEFAULT_URL = "jdbc:sqlserver://localhost:1433;databaseName=FitnessClub";
    private static final String DEFAULT_USERNAME = "Marcin";
    private static final String DEFAULT_PASSWORD = "12345";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName(DEFAULT_DRIVER_CLASS);
        return DriverManager.getConnection(DEFAULT_URL, DEFAULT_USERNAME, DEFAULT_PASSWORD);
    }

    public static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
