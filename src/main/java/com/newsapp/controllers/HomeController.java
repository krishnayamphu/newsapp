package com.newsapp.controllers;

import com.newsapp.dao.PostDAO;
import com.newsapp.models.Post;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "HomeController", value = "/home")
public class HomeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Post> posts= PostDAO.getPosts();
        request.setAttribute("posts",posts);
        request.getRequestDispatcher("home.jsp").forward(request,response);
    }
}
