<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Posts</title>
</head>
<body>
<table>
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Category</th>
        <th>User</th>
        <th>Create Date</th>
        <th>Update Date</th>
        <th>Action</th>
    </tr>
    <c:forEach var="post" items="${posts}">
        <tr>
            <td>${post.id}</td>
            <td>${post.title}</td>
            <td>${post.categoryId}</td>
            <td>${post.userId}</td>
            <td>${post.createdAt}</td>
            <td>${post.updatedAt}</td>
            <td>
                <div class="action-group">
                    <a href="post-edit?id=${post.id}">Edit</a>
                    <form action="posts" method="post">
                        <input type="hidden" name="id" value="${post.id}">
                        <button>delete</button>
                    </form>
                </div>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
