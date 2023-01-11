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
            <h3 class="mt-3">Contact Us</h3>
            <h4>NewsApp Online Digital News Portal</h4>
            <p>Address: your-address</p>
            <p>Email: your-email</p>
            <p>Phone: your-number</p>
            <hr>
            <h3 class="mt-3">GET IN TOUCH</h3>
            <form class="quick-form" action="contact" method="post">
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

    <section>
        <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d1766.761034037853!2d85.320814!3d27.67025485!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x39eb19ce1dace9ed%3A0xfb9c8b305818fb7d!2sKumaripati%2C%20Lalitpur!5e0!3m2!1sen!2snp!4v1673163067046!5m2!1sen!2snp" width="100%" height="400" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
    </section>
</main>
</body>
</html>
