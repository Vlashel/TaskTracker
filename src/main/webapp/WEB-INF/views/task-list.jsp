<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Vlashel
  Date: 02.07.2014
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>



<spring:url value="/task/" var="taskUrl"/>



<div class="container">

<h1>List of all tasks:</h1>

    <c:choose>
        <c:when test="${not empty taskList}">

            <table class="table table-striped">
                <tr>
                    <th>Type</th>
                    <th>Title</th>
                    <th>Description</th>
                </tr>
                <c:forEach items="${taskList}" var="task">
                    <tr>
                        <td>${task.type}</td>

                        <td>${task.title}</td>

                        <td>${task.description}</td>

                        <td>
                            <spring:url value="/delete-task/${task.id}" var="deleteUrl"/>

                            <form:form action="${deleteUrl}" method="get" >
                                <button class="btn btn-primary">Delete</button>
                            </form:form>
                        </td>
                    </tr>
                </c:forEach>
            </table>

        </c:when>

        <c:otherwise>

            <h1>YOU HAVE NO TASKS</h1>

        </c:otherwise>

    </c:choose>




</div>



