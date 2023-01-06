package com.newsapp.controllers;

import com.newsapp.dao.PostDAO;
import com.newsapp.models.Post;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "SingleController", value = "/single")
public class SingleController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        Post post= PostDAO.getPost(id);
        request.setAttribute("post",post);
        request.getRequestDispatcher("single.jsp").forward(request,response);
    }
}
