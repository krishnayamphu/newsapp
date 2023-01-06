package com.newsapp.dao;

import com.newsapp.database.ConnectDB;
import com.newsapp.models.Category;
import com.newsapp.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoryDAO {
    public static ArrayList<Category> getCategoris(){
        ArrayList<Category> categories=new ArrayList<>();
        try {
            Connection cn= ConnectDB.connect();
            String sql="SELECT * FROM category";
            PreparedStatement ps=cn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                Category category=new Category(rs.getInt("id"),rs.getString("name"),rs.getString("description"),rs.getString("created_at"),rs.getString("updated_at"));
                categories.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    public static Category getCategory(int id){
        Category category = null;
        try {
            Connection cn= ConnectDB.connect();
            String sql="SELECT * FROM category WHERE id=?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                category=new Category(rs.getInt("id"),rs.getString("name"),rs.getString("description"),rs.getString("created_at"),rs.getString("updated_at"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    public static Category getCategory(String name){
        Category category = null;
        try {
            Connection cn= ConnectDB.connect();
            String sql="SELECT * FROM category WHERE name=?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1,name);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                category=new Category(rs.getInt("id"),rs.getString("name"),rs.getString("description"),rs.getString("created_at"),rs.getString("updated_at"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    public static void create(Category category){
        try {
            Connection cn= ConnectDB.connect();
            String sql="INSERT INTO category (name, description) VALUES (?, ?)";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1,category.getName());
            ps.setString(2,category.getDescription());
            ps.executeUpdate();
            System.out.println("Data Inserted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(Category category){
        try {
            Connection cn= ConnectDB.connect();
            String sql="UPDATE category SET name=?, description=? WHERE id=?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1,category.getName());
            ps.setString(2,category.getDescription());
            ps.setInt(3,category.getId());
            ps.executeUpdate();
            System.out.println("Data Updated");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(int id){
        try {
            Connection cn= ConnectDB.connect();
            String sql="DELETE FROM category WHERE id=?";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
            System.out.println("Data Deleted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
