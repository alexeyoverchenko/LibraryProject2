<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Books</title>
</head>
<body>
<section>
    <h3>Library</h3>

    <c:forEach var="bookFromLib" items="${library}"> ${bookFromLib.author} | ${bookFromLib.name} </c:forEach>


    <form method="post" action="book?action=submit">
        <dl>
            <dd><input type="number" name="id" value="${book.id}" placeholder="id" /></dd>
        </dl>
        <dl>
            <dd><input type="text" name="author" value="${book.author}" placeholder="автор" /></dd>
        </dl>
        <dl>
            <dd><input type="text" name="name" value="${book.name}" placeholder="название" /></dd>
        </dl>
        <button type="submit">Save</button>
    </form>

</section>
</body>
</html>