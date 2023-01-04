<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../include/head.jsp"%>
    <title>Create Category</title>
</head>
<body>
<main>
    <%@include file="../include/sidebar.jsp"%>
    <div class="page-content">
        <form action="category-create" method="post">
            <label>Name</label>
            <input type="text" name="name" required>
            <label>Description</label>
            <textarea name="description" cols="30" rows="10"></textarea>
            <button>Create</button>
        </form>
    </div>
</main>
</body>
</html>
