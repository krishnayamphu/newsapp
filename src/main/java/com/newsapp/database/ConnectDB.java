package com.newsapp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    private static String url = "jdbc:mysql://localhost:3306";
    private static String user = "root";
    private static String password = "";
    private static String dbname = "newsapp";

    public static Connection connect() {
        Connection cn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection(url + "/" + dbname, user, password);
            System.out.println("server connected");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return cn;
    }
}
