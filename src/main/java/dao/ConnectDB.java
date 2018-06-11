package dao;

import java.sql.*;

public class ConnectDB {

    private Connection conn = null;

    public ConnectDB() {
        try {
            String password = " ";
            String user = "postgres";
            String database = "systemDB";
            String url = "jdbc:postgresql://localhost:5432/" + database;
            conn = DriverManager.getConnection(url, user, password);

            if (conn != null) {
                System.out.println("Connecting database [" + conn + "] OK");
            }

        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
    }

    public Connection getConnectionDB() {
        return conn;
    }

    public void disconnectDB() {
        System.out.println("Closing database: [" + conn + "] OK");
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}