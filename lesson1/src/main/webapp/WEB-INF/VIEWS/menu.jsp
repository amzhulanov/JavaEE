<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: JAM
  Date: 05.08.2019
  Time: 22:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<table class="table">
    <thead class="thead-dark">



    <tr>
        <c:forEach var="menu" items="${requestScope.menu}">
            <td>
                <a href="${pageContext.request.contextPath}/${menu.item}"><c:out value="${menu.value}"/></a>
            </td>
        </c:forEach>
    </tr>
    </thead>
</table>
