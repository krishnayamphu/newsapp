<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.newsapp.utils.PostExcerpt" %>
<html>
<head>
    <%@include file="head.jsp" %>
    <title>NewsApp | Contact Us</title>
</head>
<body>
<%@include file="header.jsp" %>
<main>
    <div class="container">
        <div class="content">
            <h3>Contact Us</h3>
            <h4>NewsApp Online Digital News Portal</h4>
            <p>Address: your-address</p>
            <p>Email: your-email</p>
            <p>Phone: your-number</p>
            <hr>
            <h3>GET IN TOUCH</h3>
            <form action="">
                <label>Name</label>
                <input type="text" name="name" required>
                <label>Email</label>
                <input type="email" name="email" required>
                <label>Subject</label>
                <input type="text" name="subject" required>
                <label>Message</label>
                <textarea name="message" cols="30" rows="10"></textarea>
                <button>Send</button>
            </form>
        </div>
        <%@include file="sidebar.jsp" %>
    </div>
</main>
</body>
</html>
