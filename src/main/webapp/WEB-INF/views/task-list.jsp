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
                    <th>Date added</th>
                    <th>Date finished</th>
                </tr>
                <c:forEach items="${taskList}" var="task">
                    <tr>
                        <td>${task.type}</td>

                        <td>${task.title}</td>

                        <td>${task.createdDate}</td>


                        <td>

                            <c:choose>

                                <c:when test="${task.finishedDate ne null}">
                                    ${task.finishedDate}
                                </c:when>

                                <c:otherwise>
                                    <p>Not finished</p>
                                </c:otherwise>

                            </c:choose>

                        </td>

                        <td>
                            <spring:url value="/task/${task.id}" var="viewUrl"/>
                            <a href="${viewUrl}" class="btn btn-primary " role="button">View</a>
                        </td>

                        <td>

                            <spring:url value="/finish-task/${task.id}" var="finishUrl"/>

                            <c:choose>

                                <c:when test="${task.finishedDate ne null}">
                                    <a href="${finishUrl}" class="btn btn-warning disabled" role="button">Finished</a>
                                </c:when>

                                <c:otherwise>
                                    <a href="${finishUrl}" class="btn btn-success " role="button">Finish</a>
                                </c:otherwise>

                            </c:choose>


                        </td>

                        <td>

                            <spring:url value="/delete-task/${task.id}" var="deleteUrl"/>

                            <a href="${deleteUrl}" class="btn btn-danger " role="button">Delete</a>

                        </td>
                    </tr>
                </c:forEach>
            </table>

        </c:when>

        <c:otherwise>

            <h1 class="text-info">YOU HAVE NO TASKS</h1>

        </c:otherwise>

    </c:choose>


</div>



