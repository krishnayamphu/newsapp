<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.newsapp.utils.PostExcerpt" %>
<html>
<head>
    <%@include file="head.jsp"%>
    <title>NewsApp | About Us</title>
</head>
<body>
<%@include file="header.jsp"%>
<main>
    <div class="container">
        <div class="content">
            <h3>About Us</h3>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusamus blanditiis commodi doloribus eos esse eveniet facilis iste, laboriosam libero nesciunt officiis qui quo repudiandae, saepe sequi ullam, voluptate voluptates voluptatibus?</p>
        </div>
        <%@include file="sidebar.jsp"%>
    </div>
</main>
</body>
</html>
