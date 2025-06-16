package org.example.AB.ConnectionPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class WithoutPool {
    public static void main(String[] args) {
        dataBaseConnectionWithoutPool();
    }

    private static void dataBaseConnectionWithoutPool() {
        long start = System.currentTimeMillis();
        Connection connection = getConnection();
        for (int i = 0; i < 500; i++) {
            Thread thread = new Thread(() -> dataBaseQuery(connection));
            thread.start();
        }
        System.out.println("Finished in " + (System.currentTimeMillis() - start));
    }


    private static Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306";
        String user = "root";
        String pass = "admin";

        Connection connection;
        try {
            connection = DriverManager.getConnection(url, user, pass);
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void dataBaseQuery(Connection connection) {
        try {
            connection.createStatement().execute("SELECT SLEEP(0.01)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
