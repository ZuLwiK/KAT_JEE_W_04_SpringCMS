<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Authors</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
</head>
<body>
<div>
    <div class="col-md-7 col-md-6 col-sm-offset-3">
        <table class="table table-bordered">
            <tr>
                <th colspan="4">Authors</th>
            </tr>
            <tr>
                <th>First name:</th>
                <th>Last name:</th>
                <th colspan="2"><a href='/authors/add'>
                    <button>Add</button>
                </a></th>
            </tr>
            <c:forEach items="${authors}" var="author">
                <tr>
                    <td><c:out value="${author.firstName}"/></td>
                    <td><c:out value="${author.lastName}"/></td>
                    <td><a href='/authors/edit/${author.id}'>
                        <button class="bullet-button">Edit</button>
                    </a></td>
                    <td>
                        <form action="/authors/delete/${author.id}" method="post" th:object="${author}">
                            <input type="SUBMIT" value="Delete"
                                   onclick="return confirm('Are you sure you want delete this author?')"
                                   class="decrement-arrow-button"/></form>
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="4"></td>
            </tr>
            <tr>
                <td colspan="4">Go to:</td>
            </tr>
            <tr>
                <td colspan="4"><a href="/articles/all"> Article List </a></td>
            </tr>
            <tr>
                <td colspan="4"><a href="/categories/all"> Category List </a></td>
            </tr>
            <tr>
                <td colspan="4"><a href="/"> <<<--- Back To HomePage </a></td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>
