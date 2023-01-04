package com.newsapp.controllers.post;

import com.newsapp.dao.CategoryDAO;
import com.newsapp.dao.PostDAO;
import com.newsapp.models.Category;
import com.newsapp.models.Post;
import com.newsapp.utils.MediaFile;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "PostEditController", value = "/post-edit")
public class PostEditController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ArrayList<Category> categories = CategoryDAO.getCategoris();
        String path = getServletContext().getRealPath("/uploads");
        ArrayList<String> files = MediaFile.getFiles(path);
        Post post = PostDAO.getPost(id);
        request.setAttribute("files", files);
        request.setAttribute("categories", categories);
        request.setAttribute("post",post);
        request.getRequestDispatcher("posts/edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String image = request.getParameter("image");
        int categoryId = Integer.parseInt(request.getParameter("category"));
        int userId = 1;
        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        post.setImage(image);
        post.setCategoryId(categoryId);
        post.setUserId(userId);
        post.setId(id);
        PostDAO.update(post);
        response.sendRedirect(request.getHeader("referer"));
    }
}
