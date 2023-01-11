package com.newsapp.controllers.post;

import com.newsapp.dao.PostDAO;
import com.newsapp.listeners.ContextPostListener;
import com.newsapp.models.Post;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "PostsController", value = "/posts")
public class PostsController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Post> posts = PostDAO.getPosts();
        request.setAttribute("posts", posts);
        request.getRequestDispatcher("posts/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        PostDAO.delete(id);
        new ContextPostListener(getServletContext()).update();
        response.sendRedirect(request.getHeader("referer"));
    }
}
