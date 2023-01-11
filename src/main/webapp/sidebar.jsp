<div class="sidebar">
    <h3>Latest Updates:</h3>
    <ul>
        <c:forEach var="post" items="${latestPosts}">
            <li><a href="single?id=${post.id}">${post.title}</a></li>
        </c:forEach>
    </ul>
</div>