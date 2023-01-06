package com.newsapp.dao;

import com.newsapp.database.ConnectDB;
import com.newsapp.models.Category;
import com.newsapp.models.Post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PostDAO {
    public static ArrayList<Post> getPosts() {
        ArrayList<Post> posts = new ArrayList<>();
        try {
            Connection cn = ConnectDB.connect();
            String sql = "SELECT * FROM posts";
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Post post = new Post();
                post.setId(rs.getInt("id"));
                post.setTitle(rs.getString("title"));
                post.setContent(rs.getString("content"));
                post.setImage(rs.getString("image"));
                post.setCategoryId(rs.getInt("category_id"));
                post.setUserId(rs.getInt("user_id"));
                post.setCreatedAt(rs.getString("created_at"));
                post.setUpdatedAt(rs.getString("updated_at"));
                posts.add(post);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return posts;
    }

    public static ArrayList<Post> getPosts(int categoryId) {
        ArrayList<Post> posts = new ArrayList<>();
        try {
            Connection cn = ConnectDB.connect();
            String sql = "SELECT * FROM posts WHERE category_id=?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1,categoryId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Post post = new Post();
                post.setId(rs.getInt("id"));
                post.setTitle(rs.getString("title"));
                post.setContent(rs.getString("content"));
                post.setImage(rs.getString("image"));
                post.setCategoryId(rs.getInt("category_id"));
                post.setUserId(rs.getInt("user_id"));
                post.setCreatedAt(rs.getString("created_at"));
                post.setUpdatedAt(rs.getString("updated_at"));
                posts.add(post);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return posts;
    }

    public static Post getPost(int id) {
        Post post = null;
        try {
            Connection cn = ConnectDB.connect();
            String sql = "SELECT * FROM posts WHERE id=?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                post = new Post();
                post.setId(rs.getInt("id"));
                post.setTitle(rs.getString("title"));
                post.setContent(rs.getString("content"));
                post.setImage(rs.getString("image"));
                post.setCategoryId(rs.getInt("category_id"));
                post.setUserId(rs.getInt("user_id"));
                post.setCreatedAt(rs.getString("created_at"));
                post.setUpdatedAt(rs.getString("updated_at"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return post;
    }

    public static void create(Post post) {
        try {
            Connection cn = ConnectDB.connect();
            String sql = "INSERT INTO posts (title,content,image,category_id,user_id) VALUES (?,?,?,?,?)";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, post.getTitle());
            ps.setString(2, post.getContent());
            ps.setString(3, post.getImage());
            ps.setInt(4, post.getCategoryId());
            ps.setInt(5, post.getUserId());
            ps.executeUpdate();
            System.out.println("Data Inserted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(Post post) {
        try {
            Connection cn = ConnectDB.connect();
            String sql = "UPDATE posts SET title=?,content=?,image=?,category_id=?,user_id=? WHERE id=?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, post.getTitle());
            ps.setString(2, post.getContent());
            ps.setString(3, post.getImage());
            ps.setInt(4, post.getCategoryId());
            ps.setInt(5, post.getUserId());
            ps.setInt(6, post.getId());
            ps.executeUpdate();
            System.out.println("Data Updated");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(int id) {
        try {
            Connection cn = ConnectDB.connect();
            String sql = "DELETE FROM posts WHERE id=?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Data Deleted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
