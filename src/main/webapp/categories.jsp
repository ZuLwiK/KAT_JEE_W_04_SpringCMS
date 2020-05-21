<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Categories</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
</head>
<body>
<div>
    <div class="col-md-7 col-md-6 col-sm-offset-3">
        <table class="table table-bordered">
            <tr>
                <th colspan="4">Categories</th>
            </tr>
            <tr>
                <th>Name:</th>
                <th>Description:</th>
                <th colspan="2"><a href='/categoryForm'>
                    <button>Add</button>
                </a></th>
            </tr>
            <c:forEach items="${categories}" var="category">
                <tr>
                    <td><c:out value="${category.name}"/></td>
                    <td><c:out value="${category.description}"/></td>
                    <td><a href='/categoryForm/editForm/${category.id}'>
                        <button class="bullet-button">Edit</button>
                    </a></td>
                    <td>
                        <form action="/categories/delete/${category.id}" method="post" th:object="${category}">
                            <input type="SUBMIT" value="Delete"
                                   onclick="return confirm('Are you sure you want delete this category?')"
                                   class="decrement-arrow-button"/></form>
                    </td>
                </tr>
            </c:forEach>
            <tr><td colspan="4"> </td></tr>
            <tr><td colspan="4">Go to:</td></tr>
            <tr><td colspan="4"><a href="/articles/all"> Articles List </a></td></tr>
            <tr><td colspan="4"><a href="/authors/all"> Authors List </a></td></tr>
            <tr><td colspan="4"><a href="/categories/all"> Categories List </a></td></tr>
            <tr><td colspan="4"><a href="/"> <<<--- Back To HomePage </a></td></tr>
        </table>
    </div>
</div>


</body>
</html>
