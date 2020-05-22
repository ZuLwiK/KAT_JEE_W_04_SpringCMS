<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>HomePage</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
</head>
<body>
<div>
    <div class="col-md-7 col-md-6 col-sm-offset-3">
        <table class="table table-bordered">
            <tr>
                <th colspan="3">Recently added articles</th>
            </tr>
            <tr>
                <th>Title:</th>
                <th>Created:</th>
                <th>Content:</th>
            </tr>
            <c:forEach items="${articles}" var="article">
                <tr>
                    <td><c:out value="${article.title}"/></td>
                    <td><c:out value="${article.created}"/></td>
                    <td><c:out value="${fn:substring(article.content,0,200)}"/></td>
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
                <td colspan="4"><a href="/authors/all"> Author List </a></td>
            </tr>
            <tr>
                <td colspan="4"><a href="/categories/all"> Category List </a></td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>
