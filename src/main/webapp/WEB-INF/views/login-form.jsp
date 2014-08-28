<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div id="login" class="container">

    <form:form method="post" action="j_spring_security_check" cssClass="form-signin">
        <legend class="text-info">Type login and password</legend>

        <div>
            <label class="col-sm-2 control-label">
                Login:
            </label>

            <div>
                <input id="userLogin" class="form-control" type="text" name='j_username'/>
            </div>
            <label class="col-sm-2 control-label">
                Password:
            </label>

            <div>
                <input id="userPassword" class="form-control" type="password" name='j_password'/>
            </div>
            <label class="checkbox">
                <input id="rememberMe" type="checkbox" name="_spring_security_remember_me">Remember password?
            </label>

        </div>

        <div>
            <input type="submit" class="btn-sm btn-primary btn-block" value="Ok"/>
        </div>

    </form:form>

    <spring:url value="registration" var="regurl"/>

    <a href="${regurl}">Register</a>


</div>




