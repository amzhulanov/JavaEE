<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: JAM
  Date: 03.08.2019
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<table>
    <td>
<h3>Мониторы</h3>
<table border="1" cellspacing="0" cellpadding="10">

    <c:forEach var="displays" items="${requestScope.displays}">
        <tr>
            <td >${displays.vendor}</td>
            <td >${displays.model}</td>
            <td >${displays.cost}</td>
        </tr>

        <tr>
            <td ></td><td ></td>
        </tr>
    </c:forEach>

</table>
    </td>
    <td>
    </td>
    <td>
<h3>Ноутбуки</h3>
<table border="1" cellspacing="0" cellpadding="10">

    <c:forEach var="notebooks" items="${requestScope.notebooks}">
        <tr>
            <td >${notebooks.vendor}</td>
            <td >${notebooks.model}</td>
            <td >${notebooks.cost}</td>
        </tr>

        <tr>

            <td ></td><td ></td>
        </tr>
    </c:forEach>

</table>
    </td>
</table>

