<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!

    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <h1>YOU ARE THE ADMIN</h1>
    </sec:authorize>

    <sec:authorize access="hasRole('ROLE_USER')">
        <h1>YOU ARE logged in, ${pageContext.request.userPrincipal.name}</h1>
        <a href="/new-task">create task</a>
    </sec:authorize>

    <spring:url value="/registration" var="reg"/>
    <spring:url value="/login" var="log"/>
    <sec:authorize access="hasRole('ROLE_ANONYMOUS')">
        <h1> <a href="${reg}">registration</a></h1>
        <h1> <a href="${log}">login</a></h1>
    </sec:authorize>




</h1>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
