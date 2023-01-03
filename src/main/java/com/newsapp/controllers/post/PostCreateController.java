package com.newsapp.controllers.post;

import com.newsapp.dao.CategoryDAO;
import com.newsapp.dao.PostDAO;
import com.newsapp.models.Category;
import com.newsapp.models.Post;
import com.newsapp.utils.MediaFile;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "PostCreateController", value = "/post-create")
public class PostCreateController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Category> categories= CategoryDAO.getCategoris();
        String path = getServletContext().getRealPath("/uploads");
        ArrayList<String> files = MediaFile.getFiles(path);
        request.setAttribute("files", files);
        request.setAttribute("categories",categories);
        request.getRequestDispatcher("posts/create.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String title=request.getParameter("title");
    String content=request.getParameter("content");
    String image=request.getParameter("image");
    int categoryId=Integer.parseInt(request.getParameter("category"));
    int userId=1;
        Post post=new Post();
        post.setTitle(title);
        post.setContent(content);
        post.setImage(image);
        post.setCategoryId(categoryId);
        post.setUserId(userId);
        PostDAO.create(post);
        response.sendRedirect("posts");
    }
}
