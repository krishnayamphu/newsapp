package com.newsapp.controllers.user;

import com.newsapp.dao.UserDAO;
import com.newsapp.models.User;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "UserEditController", value = "/user-edit")
public class UserEditController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        User user = UserDAO.getUser(id);
        request.setAttribute("user", user);
        request.getRequestDispatcher("users/edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String oldPassword=UserDAO.getUser(id).getPassword();
        String hash=password;
        if(!password.equals(oldPassword)){
            hash = DigestUtils.sha256Hex(password);
        }
        UserDAO.update(new User(id,username,hash));
        response.sendRedirect(request.getHeader("referer"));
    }
}
