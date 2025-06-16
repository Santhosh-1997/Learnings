package org.example.AB.ConnectionPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class WithPoolUsingBlockingQueue {
    public static void main(String[] args) {
        dataBaseConnectionWithPoolUsingBlockingQueue();
    }

    private static void dataBaseConnectionWithPoolUsingBlockingQueue() {
        long start = System.currentTimeMillis();

        BlockingQueue<Connection> connectionPool = new ArrayBlockingQueue<>(10);
        for (int i = 0; i < 9; i++) {
            connectionPool.add(getConnection());
        }

        for (int i = 0; i < 10000; i++) {
            Thread thread = new Thread(() -> dataBaseQueryWithConnectionPool(connectionPool));
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

    private static void dataBaseQueryWithConnectionPool(BlockingQueue<Connection> connectionPool) {
        try {
            Connection connection = connectionPool.take();
            dataBaseQuery(connection);
            connectionPool.put(connection);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void dataBaseQuery(Connection connection) {
        try {
            connection.createStatement().execute("SELECT SLEEP(0.01)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
