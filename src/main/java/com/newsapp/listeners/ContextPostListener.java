package com.newsapp.listeners;

import com.newsapp.dao.PostDAO;
import com.newsapp.models.Post;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import java.util.ArrayList;

public class ContextPostListener{
    private ServletContext context;

    public ContextPostListener(ServletContext context) {
        this.context = context;
    }

    public void update(){
        ArrayList<Post> latestPosts= PostDAO.getLatestPosts(5);
        context.setAttribute("latestPosts",latestPosts);

    }
}
