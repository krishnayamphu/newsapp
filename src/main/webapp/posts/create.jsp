<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Post</title>
</head>
<body>
<form action="post-create" method="post">
    <label>Title</label>
    <input type="text" name="title" required>
    <label>Content</label>
    <textarea name="content" cols="30" rows="10"></textarea>
    <label>Category</label>
    <select name="category">
        <c:forEach var="category" items="${categories}">
            <option value="${category.id}">${category.name}</option>
        </c:forEach>
    </select>
    <label>Post Image</label>
    <input type="text" name="image">
    <button type="button">Set Image</button>
    <button>Create</button>
</form>
</body>
</html>
