<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../include/head.jsp"%>
    <title>All Media Files</title>
</head>
<body>
<main>
    <%@include file="../include/sidebar.jsp"%>
    <div class="page-content">
        <form method="POST" enctype="multipart/form-data" action="media">
            File to upload: <input type="file" name="upfile">
            <button>Upload</button>
        </form>
        <hr>
        <h3>All Media Files</h3>
        <div class="media-container">
            <c:forEach var="file" items="${files}">
                <div class="media">
                    <img src="uploads/${file}" alt="">
                    <div class="media-action">
                        <a href="">View</a>
                        <form action="media-del" method="post">
                            <input type="hidden" name="image" value="${file}">
                            <button>Delete</button>
                        </form>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</main>
</body>
</html>
