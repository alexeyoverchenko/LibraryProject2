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

        <div>
            <table border="1" width="20%" cellpadding="3">
                <tr>
                    <td><c:out value="${book.author}"/></td>
                    <td><c:out value="${book.name}"/></td>
                    <td>
<%--                        <form method ="post" action="book">--%>

                            <button type="submit">X</button>
<%--                        </form>--%>
                    </td>
                </tr>
            </table>

        </div>
    </c:forEach>

    <form method="post" action="book">
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