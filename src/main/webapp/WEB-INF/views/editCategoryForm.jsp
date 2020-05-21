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
    <title>Edit Category</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
    <script src="jquery-3.4.1.min.js"></script>
    <script src="categories.js"></script>
    <link rel="icon"
          type="image/png"
          href="category.png"/>
</head>
<body>
<div class="container">
    <h1 class="col-xs-12 col-sm-6 col-sm-offset-3">Edit category:</h1>
</div>
<div class="container">
    <div class="col-xs-12 col-sm-6 col-sm-offset-3">
        <form:form method="POST" modelAttribute="category" id="editCategoryForm">
            <div class="form-group">
                <label for="name">Name:</label>
                <form:input id="name" path="name" value="${category.name}" class="form-control"
                            required="true"/><form:errors
                    path="name"/>
            </div>

            <div class="form-group">
                <label for="description">Description:</label>
                <form:input path="description" value="${category.description}" id="description" class="form-control"/><form:errors
                    path="description"/>
            </div>
            <input type="hidden" name="categoryId" value="${category.id}"/>
            <a href='/categories/all'>
                <button type="button" id="cancelForm" class="btn btn-primary">Cancel</button>
            </a>
            <button type="submit" id="submitForm" class="btn btn-primary">Submit</button>
        </form:form>
    </div>
</div>

</body>
</html>
