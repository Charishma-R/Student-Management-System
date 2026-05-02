package com.student;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    
    static String url = "jdbc:mysql://localhost:3306/student_management";
    static String username = "root";
    static String password = "root";
    
    public static Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Database Connected Successfully!");
        } catch (Exception e) {
            System.out.println("Connection Failed: " + e.getMessage());
        }
        return con;
    }
}
