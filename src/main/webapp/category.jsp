<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.newsapp.utils.PostExcerpt" %>
<html>
<head>
    <%@include file="head.jsp"%>
    <title>NewsApp | Category</title>
</head>
<body>
<%@include file="header.jsp"%>
<main>
    <div class="container">
        <div class="content">
            <div class="post">
                <c:forEach var="post" items="${posts}">
                    <div class="post-card">
                        <img class="post-image" src="uploads/${post.image}" alt="">
                        <h4 class="post-heading"><a href="single?id=${post.id}">${post.title}</a></h4>
                        <p>
                                ${PostExcerpt.getExcerpt(post.content,100)}
                        </p>
                    </div>
                </c:forEach>
            </div>
        </div>
        <%@include file="sidebar.jsp"%>
    </div>
</main>
</body>
</html>
