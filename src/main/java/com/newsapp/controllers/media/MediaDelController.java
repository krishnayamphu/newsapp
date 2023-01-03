package com.newsapp.controllers.media;

import com.newsapp.utils.MediaFile;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MediaDelController", value = "/media-del")
public class MediaDelController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = getServletContext().getRealPath("/uploads");
        String name=request.getParameter("image");
        MediaFile.remove(path,name);
        response.sendRedirect(request.getHeader("referer"));
    }
}
