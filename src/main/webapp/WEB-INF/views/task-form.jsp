<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
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
<h1>Please, fill in</h1>

<spring:url value="new-task" var="url"/>
<form:form action="${url}" method="post" modelAttribute="taskDto">
    <div class="form-group">
        <div class="col-lg-4 col-md-4 col-sm-5">

            Type: <form:input path="type" class="form-control"/><br/>
            Name: <form:input path="name" class="form-control"/><br/>
            Description: <form:textarea path="description" class="form-control" id="description" name=""/><br/>
            <form:button class="btn btn-primary">Submit</form:button>
        </div>
    </div>
</form:form>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
</body>
</html>