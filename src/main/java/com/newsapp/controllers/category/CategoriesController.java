package com.newsapp.controllers.category;

import com.newsapp.dao.CategoryDAO;
import com.newsapp.models.Category;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CategoriesController", value = "/category")
public class CategoriesController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Category> categories= CategoryDAO.getCategoris();
        request.setAttribute("categories",categories);
        request.getRequestDispatcher("category/index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        CategoryDAO.delete(id);
        response.sendRedirect(request.getHeader("referer"));
    }
}
