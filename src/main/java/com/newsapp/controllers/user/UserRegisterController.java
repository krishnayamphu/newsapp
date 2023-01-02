package com.newsapp.controllers.user;

import com.newsapp.dao.UserDAO;
import com.newsapp.models.User;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserRegisterController", value = "/register")
public class UserRegisterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("users/create.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String hash = DigestUtils.sha256Hex(password);
        UserDAO.create(new User(username,hash));
        response.sendRedirect("users");
    }
}
