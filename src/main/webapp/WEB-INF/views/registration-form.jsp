<%--
  Created by IntelliJ IDEA.
  User: Vlashel
  Date: 06.06.2014
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Registration form</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Creating new task</title>

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">

    <!-- Optional theme -->
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">

    <!-- Latest compiled and minified JavaScript -->
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

</head>
<body>
<div class="container">
<form:form action="/registration" modelAttribute="userDto" method="POST"  cssClass="form-signin">
<h1>Registration:</h1>
    <div class="form-group">
        <div class="col-lg-4 col-md-4 col-sm-5">
            <form:input path="name" placeholder="Name" cssClass="form-control"/><br/>
            <form:input path="password" placeholder="Password" cssClass="form-control"/><br/>
            <form:button class="btn btn-primary">Submit</form:button><br/>
        </div>
    </div>
</form:form>
</div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
</body>
</html>
