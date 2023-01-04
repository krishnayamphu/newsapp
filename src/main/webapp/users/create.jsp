<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register new user</title>
</head>
<body>
<main>
    <%@include file="../include/head.jsp"%>
    <div class="page-content"></div>
</main>
<form action="register" method="post">
    <label>Username</label>
    <input type="text" name="username" required>
    <label>Password</label>
    <input type="password" name="password" required>
    <button>Create</button>
</form>
</body>
</html>
