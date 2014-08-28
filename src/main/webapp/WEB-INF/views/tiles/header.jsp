<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="navbar navbar-default navbar-fixed-top" roles="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>

            <spring:url value="/" var="mainurl"/>
            <spring:url value="new-task" var="newtaskurl"/>
            <spring:url value="task-list" var="tasklisturl"/>


            <a class="navbar-brand" href="${mainurl}">Task Tracker</a>

            <sec:authorize access="isAuthenticated()">
                <p class="navbar-text">Signed in as ${pageContext.request.userPrincipal.name}</p>

                <a class="navbar-text" href="${newtaskurl}">Create a task</a>
                <a class="navbar-text" href="${tasklisturl}">List of all tasks</a>
            </sec:authorize>
        </div>

        <spring:url value="admin" var="adminurl"/>

        <sec:authorize access="hasRole('ROLE_ADMIN')">
            <a class="navbar-text" href="${adminurl}">Admin panel</a>
        </sec:authorize>


        <sec:authorize access="isAuthenticated()">

            <spring:url value="logout" var="logurl"/>

            <div class="collapse navbar-collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="${logurl}"> Logout </a></li>
                </ul>
            </div>
        </sec:authorize>
    </div>
</div>


<style>
    .container {
        margin-top: 5%;
    }

</style>