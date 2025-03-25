package com.example.student_entering;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class student_db {
    private static final String URL = "jdbc:mariadb://localhost:3306/student_db";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection connect(){
        try{
            return DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }





}
