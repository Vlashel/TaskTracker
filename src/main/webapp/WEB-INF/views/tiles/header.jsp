<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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

            <a class="navbar-brand" href="/">Task Tracker</a>

            <sec:authorize access="isAuthenticated()">
                <p class="navbar-text">Signed in as ${pageContext.request.userPrincipal.name}</p>

                <a class="navbar-text" href="/new-task">Create a task</a>
                <a class="navbar-text" href="/task-list">List of all tasks</a>
            </sec:authorize>
        </div>

        <sec:authorize access="hasRole('ROLE_ADMIN')">
            <a class="navbar-text" href="/admin">Admin panel</a>
        </sec:authorize>


        <sec:authorize access="isAuthenticated()">

            <div class="collapse navbar-collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="/logout"> Logout </a></li>
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