<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="book.css" type="text/css" media="screen"/>
<html>
<head>
    <title>Library</title>
</head>
<body>
<section>
    <h3 id="h3">Library</h3>

    <c:forEach var="book" items="${library}">
        <div>
            <table border="1" width="20%" cellpadding="3">
                <tr>
                    <td><c:out value="${book.author}"/></td>
                    <td><c:out value="${book.name}"/></td>
                    <td>
                        <button onclick="location.href='http://localhost:8080/edit?id=${book.id}'" type="button">/</button>
                    </td>
                    <td>
                        <form method ="post">
                            <input type="hidden" name="id" value="${book.id}" />
                            <input type="hidden" name="action" value="delete" />
                            <button type="submit">X</button>
                        </form>
                    </td>
                </tr>
            </table>
        </div>
    </c:forEach>

    <div id="redact_wrapper">
        <form method="post">
            <div id="redact_field">
            </div>
        </form>
    </div>

    <p>number of pages: <c:out value="${pageNumber}"/> </p>
    <p>line limit: <c:out value="${pageLimit}"/> </p>
    <form method ="post">
        <input type="number" name="lines_number" placeholder="enter your line limit" />
        <input type="hidden" name="action" value="set" />
        <button type="submit">Set</button>
    </form>

    <div>
        <form method ="post">
            <input type="hidden" name="action_button" value="back" />
            <button id="back_button">Back</button>
        </form>
        <form method ="post">
            <input type="hidden" name="page" value="${1 + slider}" />
            <input type="hidden" name="action_button" value="first" />
            <button type="submit">${1 + slider}</button>
        </form>
        <form method ="post">
            <input type="hidden" name="page" value="${2 + slider}" />
            <input type="hidden" name="action_button" value="second" />
            <button type="submit">${2 + slider}</button>
        </form>
        <form method ="post">
            <input type="hidden" name="page" value="${3 + slider}" />
            <input type="hidden" name="action_button" value="third" />
            <button type="submit">${3 + slider}</button>
        </form>
        <form method ="post">
            <input type="hidden" name="action_button" value="next" />
            <button id="next_button">Next</button>
        </form>
    </div>

    <form method="post">
        <div id="wrapper">
            <div id="field">
                <dl>
                    <input type="text" name="author" placeholder="author" />
                </dl>
                <dl>
                    <input type="text" name="name" placeholder="name" />
                </dl>
            </div>
        </div>
        <input type="hidden" name="action" value="save" />
        <button type="submit">Save</button>
    </form>

    <button id="add_button">Add</button>
    <script>
        let buttonElement = document.getElementById('add_button');
        buttonElement.addEventListener('click', function () {
            let wrapper = document.querySelector('#wrapper');
            let element = document.createElement('div');
            element.innerHTML =
                '<p>' +
                '<dl>' +
                '<input type="text" name="author" placeholder="author" />\n' +
                '</dl>' +
                '<dl>' +
                '<input type="text" name="name" placeholder="name" />\n' +
                '</dl>' +
                '</p>'

            wrapper.appendChild(element);
        });
    </script>
</section>
</body>
</html>