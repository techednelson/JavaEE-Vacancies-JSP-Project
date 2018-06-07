package dao;

import java.sql.*;

public class ConnectDB {

    private Connection conn = null;

    public ConnectDB() {
        try {
            String password = "!@#321Nel";
            String user = "postgres";
            String bd = "systemDB";
            String url = "jdbc:postgresql://localhost:5432/" + bd;
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