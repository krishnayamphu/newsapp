<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Categories</title>
</head>
<body>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Create Date</th>
        <th>Action</th>
    </tr>
    <c:forEach var="category" items="${categories}">
        <tr>
            <td>${category.id}</td>
            <td>${category.name}</td>
            <td>${category.createdAt}</td>
            <td>
                <div class="action-group">
                    <a href="category-edit?id=${category.id}">Edit</a>
                    <form action="category" method="post">
                        <input type="hidden" name="id" value="${category.id}">
                        <button>delete</button>
                    </form>
                </div>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
