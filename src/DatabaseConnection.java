package com.example.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String DB_URL_POL_SK = "jdbc:mysql://localhost:3306/pol_bel_db";
    private static final String DB_URL_BEL_POL = "jdbc:mysql://localhost:3306/bel_pol_db";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static Connection getConnection(String dbName) throws SQLException {
        String dbUrl;
        if("pol_bel_db".equals(dbName)) {
            dbUrl = DB_URL_POL_SK;
        } else if("bel_pol_db".equals(dbName)) {
            dbUrl = DB_URL_BEL_POL;
        } else {
            throw new SQLException("Unknown database name");
        }
        return DriverManager.getConnection(dbUrl, USER, PASS);
    }
}