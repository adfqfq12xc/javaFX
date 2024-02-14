package com.example.demo7;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

import java.sql.*;

public class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/ali";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "0000";

    private static Connection connection;

    private DatabaseConnection() {
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // private constructor to prevent instantiation
    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("Connection exist");
        }
        return connection;
    }


    public static int getclient(String user, String pass) throws SQLException {
        String sql = "SELECT * FROM LOGIN WHERE username=? AND pass=?";
        var  con=DatabaseConnection.getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        pstmt.setString(1, user);
        pstmt.setString(2, pass);

        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                System.out.println(rs.getString("id"));
                return rs.getInt("id");
            } else {
                System.out.println("User not found");
            }

        }
        return 0;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                connection = null;
            }
        }
    }



}

