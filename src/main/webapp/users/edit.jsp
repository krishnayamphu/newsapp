<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../include/head.jsp"%>
    <title>User Details</title>
</head>
<body>
<main>
    <%@include file="../include/sidebar.jsp"%>
    <div class="page-content">
        <form action="user-edit" method="post">
            <input type="hidden" name="id" value="${user.id}">
            <label>Username</label>
            <input type="text" name="name" value="${user.username}" required>
            <label>Password</label>
            <input type="password" name="password" value="${user.password}" required>
            <button>Update</button>
        </form>
    </div>
</main>
</body>
</html>
