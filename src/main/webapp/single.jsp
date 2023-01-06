<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.newsapp.utils.PostExcerpt" %>
<html>
<head>
    <%@include file="head.jsp"%>
    <title>NewsApp | Homepage</title>
</head>
<body>
<%@include file="header.jsp"%>
<main>
    <div class="container">
        <div class="content">
            <div class="post-single">
                <div class="post-card">
                    <h1 class="post-heading">${post.title}</h1>
                    <img class="post-image" src="uploads/${post.image}" alt="">
                    <p>
                        ${post.content}
                    </p>
                </div>
            </div>
        </div>
        <%@include file="sidebar.jsp"%>
    </div>
</main>
</body>
</html>
