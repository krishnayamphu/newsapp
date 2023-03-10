<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../include/head.jsp" %>
    <title>Posts</title>
</head>
<body>
<main>
    <%@include file="../include/sidebar.jsp" %>
    <div class="page-content">
        <h3>All Posts</h3>
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
                    <td>${post.getCategory(post.categoryId)}</td>
                    <td>${post.userId}</td>
                    <td>${post.createdAt}</td>
                    <td>${post.updatedAt}</td>
                    <td>
                        <div class="action-group">
                            <a href="post-edit?id=${post.id}">Edit</a>
                            <form action="posts" method="post">
                                <input type="hidden" name="id" value="${post.id}">
                                <button>Delete</button>
                            </form>
                        </div>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</main>
</body>
</html>
