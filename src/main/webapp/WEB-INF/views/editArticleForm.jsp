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
    <title>Edit article</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
    <script src="jquery-3.4.1.min.js"></script>
    <script src="articles.js"></script>
    <link rel="icon"
          type="image/png"
          href="article.png"/>
</head>
<body>
<div class="container">
    <h1 class="col-xs-12 col-sm-6 col-sm-offset-3">Edit article:</h1>
</div>
<div class="container">
    <div class="col-xs-12 col-sm-6 col-sm-offset-3">
        <form:form method="POST" modelAttribute="article">
            <div class="form-group">
                <label for="title">Title:</label>
                <form:input id="title" path="title" value="${article.title}" class="form-control"/><form:errors
                    path="title"/>
            </div>
            <div class="form-group">
                <label for="author">Author:</label>
                <form:select path="author" value="${article.author}" itemLabel="lastName" itemValue="id"
                             items="${authors}" class="form-control"/><form:errors path="author"/>
            </div>
            <div class="form-group">
                <label for="category">Categories:</label>
                <form:select path="categories" value="${article.categories}" itemLabel="name" itemValue="id"
                             items="${categories}" multiple="true"  class="form-control"/><form:errors path="categories"/>
            </div>
            <div class="form-group">
                <label for="content">Content:</label>
                <form:textarea path="content" value="${article.content}" id="content" class="form-control"
                               type="content"/><form:errors path="content"/>
            </div>
<%--            <form:hidden path="created" value="${article.created}"/>--%>
        <%--    <form:hidden path="created"/>--%>
            <a href='/articles/all'>
                <button type="button" id="cancelForm" class="btn btn-primary">Cancel</button>
            </a>
            <button type="submit" id="submitForm" class="btn btn-primary">Submit</button>
        </form:form>
    </div>
</div>
</body>
</html>
