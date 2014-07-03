<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Vlashel
  Date: 02.07.2014
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <title></title>
</head>
<body>
<spring:url value="/task/" var="taskUrl"/>

<h1>List of all tasks:</h1>

<c:if test="${not empty taskList}">


    <c:forEach items="${taskList}" var="task">
        Type: ${task.type} <br/>
        Name: ${task.name} <br/>
        Desc: ${task.description} <br/>
    </c:forEach>


</c:if>
</body>
</html>
