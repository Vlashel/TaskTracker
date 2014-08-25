<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="container">

    <spring:url value="/registration" var="reg"/>
    <spring:url value="/login" var="log"/>
    <sec:authorize access="hasRole('ROLE_ANONYMOUS')">
        <form:form action="${reg}" method="get" >
        <button class="btn btn-primary">Register</button>
        </form:form>

        <form:form action="${log}" method="get" >
            <button class="btn btn-primary">Login</button>
        </form:form>
    </sec:authorize>

    <P> The time on the server is ${serverTime}. </P>


</div>







