package com.newsapp.dao;

import com.newsapp.database.ConnectDB;
import com.newsapp.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO {
    public static ArrayList<User> getUsers(){
        ArrayList<User> users=new ArrayList<>();
        try {
            Connection cn= ConnectDB.connect();
            String sql="SELECT * FROM users";
            PreparedStatement ps=cn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                User user=new User(rs.getInt("id"),rs.getString("username"),rs.getString("password"));
                users.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public static User getUser(int id){
        User user = null;
        try {
            Connection cn= ConnectDB.connect();
            String sql="SELECT * FROM users WHERE id=?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                user=new User(rs.getInt("id"),rs.getString("username"),rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public static void create(User user){
        try {
            Connection cn= ConnectDB.connect();
            String sql="INSERT INTO users (username, password) VALUES (?, ?)";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            ps.executeUpdate();
            System.out.println("Data Inserted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(User user){
        try {
            Connection cn= ConnectDB.connect();
            String sql="UPDATE users SET username=?, password=? WHERE id=?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            ps.setInt(3,user.getId());
            ps.executeUpdate();
            System.out.println("Data Updated");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(int id){
        try {
            Connection cn= ConnectDB.connect();
            String sql="DELETE FROM users WHERE id=?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
            System.out.println("Data Deleted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
