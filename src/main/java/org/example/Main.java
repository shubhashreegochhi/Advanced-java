package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "shubha@2610";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //Step-1
            DriverManager.getConnection(url,user,password); //Step - 2
            System.out.println("now we will connect to the database");


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

        }


    }
}