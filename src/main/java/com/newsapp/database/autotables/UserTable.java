package com.newsapp.database.autotables;

import com.newsapp.database.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserTable {
    public static void create() {
        try {
            Connection cn = ConnectDB.connect();
            String sql = "CREATE TABLE users (id int AUTO_INCREMENT,username varchar(20) NOT NULL,password varchar(256),PRIMARY KEY(id),UNIQUE(username))";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("User Table Created");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void drop() {
        try {
            Connection cn = ConnectDB.connect();
            String sql = "DROP TABLE users;";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("User Table Deleted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
