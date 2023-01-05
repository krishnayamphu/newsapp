<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../include/head.jsp"%>
    <title>Users</title>
</head>
<body>
<main>
    <%@include file="../include/sidebar.jsp"%>
    <div class="page-content">
        <h3>All Users</h3>
        <table>
            <tr>
                <th>Id</th>
                <th>Username</th>
                <th>Password</th>
                <th>Action</th>
            </tr>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.username}</td>
                    <td>${user.password}</td>
                    <td>
                        <div class="action-group">
                            <a href="user-edit?id=${user.id}">Edit</a>
                            <form action="users" method="post">
                                <input type="hidden" name="id" value="${user.id}">
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
