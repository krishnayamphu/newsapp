package com.newsapp.database.autotables;

import com.newsapp.database.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PostTable {
    public static void create() {
        /**
         * id,title,content,image,category_id,user_id,created_at,updated_at
         */
        try {
            Connection cn = ConnectDB.connect();
            String sql = "CREATE TABLE posts (id int AUTO_INCREMENT,title varchar(256) NOT NULL,content text,image varchar(256), category_id int, user_id int, created_at timestamp default current_timestamp,updated_at timestamp default current_timestamp,PRIMARY KEY(id),UNIQUE(title))";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("Posts Table Created");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void drop() {
        try {
            Connection cn = ConnectDB.connect();
            String sql = "DROP TABLE posts";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("Category Table Deleted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
