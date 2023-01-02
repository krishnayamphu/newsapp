package com.newsapp.database.autotables;

import com.newsapp.database.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CategoryTable {
    public static void create() {
        try {
            Connection cn = ConnectDB.connect();
            String sql = "CREATE TABLE category (id int AUTO_INCREMENT,name varchar(30) NOT NULL,description varchar(256),created_at timestamp default current_timestamp,updated_at timestamp default current_timestamp,PRIMARY KEY(id),UNIQUE(name))";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("Category Table Created");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void drop() {
        try {
            Connection cn = ConnectDB.connect();
            String sql = "DROP TABLE category;";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("Category Table Deleted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
