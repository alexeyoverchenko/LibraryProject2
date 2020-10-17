<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="book.css" type="text/css" media="screen"/>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<section>
    <h3 id="h3">Edit</h3>

    <form method="post" >
<%--        action="/book"--%>
        <div id="field">
            <dl>
                <dd><input type="text" name="author_new" placeholder="author" /></dd>
            </dl>
            <dl>
                <dd><input type="text" name="name_new" placeholder="name" /></dd>
            </dl>
            <form method="post">
                <input type="hidden" name="action" value="update" />
                <button type="submit">Update</button>
            </form>
        </div>
    </form>

</section>
</body>
</html>