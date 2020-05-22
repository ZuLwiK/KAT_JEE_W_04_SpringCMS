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
    <h1 class="col-xs-12 col-sm-6 col-sm-offset-3">Add article:</h1>
</div>
<div class="container">
    <div class="col-xs-12 col-sm-6 col-sm-offset-3">
        <form:form method="POST" modelAttribute="article" id="addArticleForm">
            <div class="form-group">
                <label for="title">Title:</label>
                <form:input id="title" path="title" class="form-control"
                            required="true"/><form:errors path="title"/>
            </div>
            <div class="form-group">
                <label for="author">Author:</label>
                <form:select path="author" itemLabel="lastName" itemValue="id"
                             items="${authors}" id="author" class="form-control"/>
                <form:errors
                    path="author"/>
            </div>
            <div class="form-group">
                <label for="categories">Categories:</label>
                <form:select multiple="true" path="categories" itemLabel="name" itemValue="id" items="${categories}"/> <form:errors path="categories"/>
            </div>
            <div class="form-group">
                <label for="content">Content:</label>
                <form:textarea path="content" id="content" class="form-control"
                               type="content" rows="5" cols="20"/><form:errors path="content"/>
            </div>
            <input type="hidden" name="articleId" value="${article.id}"/>
            <a href='/articles/all'>
                <button type="button" id="cancelForm" class="btn btn-primary">Cancel</button>
            </a>
            <button type="submit" id="submitForm" class="btn btn-primary">Submit</button>
        </form:form>
    </div>
</div>
</body>
</html>
