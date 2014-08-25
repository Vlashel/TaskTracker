<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="container">
    <c:choose>
        <c:when test="${not empty userList}">

            <table class="table table-striped">
                <tr>
                    <th>Name</th>
                    <th>Role</th>
                    <th>Registration Date</th>

                </tr>
                <c:forEach items="${userList}" var="user">
                    <tr>
                        <td>${user.name}</td>

                        <td>
                            <c:forEach items="${user.roles}" var="role">
                                ${role.role}
                            </c:forEach>
                        </td>

                        <td>${user.registrationDate}</td>


                        <td>

                            <spring:url value="/delete-user/${user.id}" var="deleteUrl"/>

                            <a href="${deleteUrl}" class="btn btn-danger " role="button">Delete</a>

                        </td>
                    </tr>
                </c:forEach>
            </table>

        </c:when>

        <c:otherwise>

            <h1 class="text-info">NO USERS</h1>

        </c:otherwise>

    </c:choose>
</div>