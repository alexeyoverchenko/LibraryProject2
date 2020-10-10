<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Library</title>
</head>
<body>
<section>
    <h3>Library</h3>

    <c:forEach var="book" items="${library}">
        <div><c:out value="${book.author} | ${book.name}"/></div>
        </c:forEach>

    <form method="post" action="book">
        <dl>
            <dd><input type="number" name="id" placeholder="id" /></dd>
        </dl>
        <dl>
            <dd><input type="text" name="author" placeholder="автор" /></dd>
        </dl>
        <dl>
            <dd><input type="text" name="name" placeholder="название" /></dd>
        </dl>
        <button type="submit">Save</button>
    </form>

</section>
</body>
</html>