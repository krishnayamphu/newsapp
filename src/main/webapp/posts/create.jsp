<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../include/head.jsp" %>
    <title>Create Post</title>
</head>
<body>
<main>
    <%@include file="../include/sidebar.jsp" %>
    <div class="page-content">
        <h3>New Post</h3>
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
            <div class="post-media-group">
                <label>Post Image</label>
                <input type="hidden" name="image" id="image">
                <div id="postImageWrap"></div>
                <button type="button" onclick="mediaOpen()">Set Image</button>
            </div>
            <button>Create</button>

            <div id="mediaOverlay" class="media-overlay">
                <div class="media-container">
                    <button class="btn-close" type="button" onclick="mediaClose()"> X</button>
                    <c:forEach var="file" items="${files}">
                        <div class="media">
                            <img onclick="setImage('${file}')" src="uploads/${file}" alt="">
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
        </form>
    </div>
</main>

<script>
    function mediaOpen() {
        document.getElementById("mediaOverlay").style.display = "flex";
    }

    function mediaClose() {
        document.getElementById("mediaOverlay").style.display = "none";
    }

    function setImage(image) {
        const oImg = document.createElement("img");
        const btnRemove = document.createElement("button");
        const path = 'uploads/' + image;
        oImg.setAttribute('src', path);
        oImg.setAttribute('alt', 'na');
        oImg.setAttribute('class', 'post-image');

        btnRemove.setAttribute('type', 'button');
        btnRemove.innerHTML = "Remove Image";
        btnRemove.addEventListener('click', function (e) {
            removeImage(image);
            e.preventDefault();
        });
        document.getElementById("image").value = image;
        document.getElementById("postImageWrap").replaceChildren(oImg, btnRemove);
        mediaClose();
    }

    function removeImage(item) {
        document.getElementById("image").value = '';
        document.getElementById("postImageWrap").replaceChildren('');
    }
</script>
</body>
</html>
