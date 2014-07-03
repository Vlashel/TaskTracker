<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<form:form method="post" action="j_spring_security_check" cssClass="form-signin">
    <legend class="text-info">Enter username and password</legend>

    <div>
        <label class="col-sm-2 control-label">
            Name:
        </label>

        <div>
            <input  class="form-control" type="text" name='j_username'/>
        </div>
        <label class="col-sm-2 control-label">
            Password:
        </label>

        <div>
            <input  class="form-control" type="password" name='j_password'/>
        </div>


    </div>

    <div>
        <input type="submit" class="btn-sm btn-primary" value="Ok"/>
    </div>
</form:form>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
</body>
</html>