<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Articles</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
</head>
<body>
<div>
    <div class="col-md-7 col-md-6 col-sm-offset-3">
        <table class="table table-bordered">
            <tr>
                <th colspan="8">Articles</th>
            </tr>
            <tr>
                <th>Title:</th>
                <th>Author:</th>
                <th>Categories:</th>
                <th>Content:</th>
                <th>Created:</th>
                <th>Updated:</th>
                <th colspan="2"><a href='/articles/add'>
                    <button>Add</button>
                </a></th>
            </tr>
            <c:forEach items="${articles}" var="article">
                <tr>
                    <td><c:out value="${article.title}"/></td>
                    <td><c:out value="${article.author.lastName}"/></td>
                    <td><c:forEach items="${article.categories}" var="category"><c:out
                            value="${category.name}"/><br></c:forEach></td>
                    <td><c:out value="${article.content}"/></td>
                    <td><c:out value="${article.created}"/></td>
                    <td><c:out value="${article.updated}"/></td>
                    <td><a href='/articles/edit/${article.id}'>
                        <button class="bullet-button">Edit</button>
                    </a></td>
                    <td>
                        <form action="/articles/delete/${article.id}" method="post" th:object="${article}">
                            <input type="SUBMIT" value="Delete"
                                   onclick="return confirm('Are you sure you want delete this article?')"
                                   class="decrement-arrow-button"/></form>
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="8"></td>
            </tr>
            <tr>
                <td colspan="8">Go to:</td>
            </tr>
            <tr>
                <td colspan="8"><a href="/authors/all"> Author List </a></td>
            </tr>
            <tr>
                <td colspan="8"><a href="/categories/all"> Category List </a></td>
            </tr>
            <tr>
                <td colspan="8"><a href="/"> <<<--- Back To HomePage </a></td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>
