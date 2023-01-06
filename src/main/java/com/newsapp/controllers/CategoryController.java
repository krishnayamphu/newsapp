package com.newsapp.controllers;

import com.newsapp.dao.CategoryDAO;
import com.newsapp.dao.PostDAO;
import com.newsapp.models.Post;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CategoryController", value = "/cat")
public class CategoryController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("name");
        int categoryId= CategoryDAO.getCategory(name).getId();
        ArrayList<Post> posts= PostDAO.getPosts(categoryId);
        request.setAttribute("posts",posts);
        request.getRequestDispatcher("category.jsp").forward(request,response);
    }
}
