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
                        <form method ="post">
                            <input type="hidden" name="id" value="${book.id}" />
                            <input type="hidden" name="action" value="edit" />
                            <button type="submit">/</button>
                        </form>
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


    <form method ="post">
        <input type="number" name="lines_number" placeholder="set number of lines" />
        <input type="hidden" name="action" value="set" />
        <button type="submit">Set</button>
    </form>

    <div>
        <form method ="post">
            <input type="hidden" name="page" value="${1}" />
            <input type="hidden" name="action_button" value="first" />
            <button type="submit">1</button>
        </form>
        <form method ="post">
            <input type="hidden" name="page" value="${2}" />
            <input type="hidden" name="action_button" value="second" />
            <button type="submit">2</button>
        </form>
    </div>

    <div id="wrapper">
        <form method="post">
            <div id="field">
                <dl>
                    <dd><input type="text" name="author" placeholder="author" /></dd>
                </dl>
                <dl>
                    <dd><input type="text" name="name" placeholder="name" /></dd>
                </dl>
                <%--there was save button--%>
                <form method="post">
                    <input type="hidden" name="action" value="save" />
                    <button type="submit">Save</button>
                </form>
            </div>
        </form>
    </div>

    <button id="add_button">Add</button>
    <script>
        let wrapper = document.querySelector('#wrapper')
        let element = document.createElement('div');
        const buttonElement = document.getElementById('add_button');
        buttonElement.addEventListener('click', function () {
            element.innerHTML =
                '<p>' +
                '<div id="field">\n' +
                '                <dl>\n' +
                '                    <dd><input type="text" name="author" placeholder="author" /></dd>\n' +
                '                </dl>\n' +
                '                <dl>\n' +
                '                    <dd><input type="text" name="name" placeholder="name" /></dd>\n' +
                '                </dl>\n' +
                '            </form>\n' +
                '    </p>'
            wrapper.appendChild(element)
        });
    </script>
</section>
</body>
</html>