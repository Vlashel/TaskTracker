<%--
  Created by IntelliJ IDEA.
  User: Vlashel
  Date: 06.06.2014
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false" pageEncoding="UTF-8"%>

<spring:url value="registration" var="url" />

<div class="container">
	<form:form method="post" action="${url}" modelAttribute="userDto"
		cssClass="form-signin">
		<legend class="text-info">Registration:</legend>

		<div>
			<label class="col-sm-2 control-label"> Login: </label>

			<div>
				<form:input path="name" cssClass="form-control" />
			</div>
			<label class="col-sm-2 control-label"> Password: </label>

			<div>
				<form:password path="password" cssClass="form-control" />
			</div>

		</div>

		<div>
			<input type="submit" class="btn-sm btn-primary btn-block" value="Ok" />
		</div>


        <input type="hidden"
               name="${_csrf.parameterName}"
               value="${_csrf.token}"/>

	</form:form>
</div>

