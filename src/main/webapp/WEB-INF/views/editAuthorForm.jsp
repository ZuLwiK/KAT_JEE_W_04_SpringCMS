<%--
  Created by IntelliJ IDEA.
  User: micha
  Date: 19.05.2020
  Time: 01:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit author</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
    <script src="jquery-3.4.1.min.js"></script>
    <script src="authors.js"></script>
    <link rel="icon"
          type="image/png"
          href="author.png"/>
</head>
<body>
<div class="container">
    <h1 class="col-xs-12 col-sm-6 col-sm-offset-3">Edit author:</h1>
</div>
<div class="container">
    <div class="col-xs-12 col-sm-6 col-sm-offset-3">
        <form:form method="POST" modelAttribute="author" id="editAuthorForm">
            <div class="form-group">
                <label for="firstName">First name:</label>
                <form:input id="firstName" path="firstName" value="${author.firstName}" class="form-control"
                            required="true"/><form:errors
                    path="firstName"/>
            </div>
            <div class="form-group">
                <label for="firstName">Last name:</label>
                <form:input id="lastName" path="lastName" value="${author.lastName}" class="form-control"
                            required="true"/><form:errors
                    path="lastName"/>
            </div>
            <input type="hidden" name="authorId" value="${author.id}"/>
            <a href='/authors/all'>
                <button type="button" id="cancelForm" class="btn btn-primary">Cancel</button>
            </a>
            <button type="submit" id="submitForm" class="btn btn-primary">Submit</button>
        </form:form>
    </div>
</div>
</body>
</html>
