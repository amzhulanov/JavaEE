<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: JAM
  Date: 03.08.2019
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<jsp:include page="head.jsp">
    <jsp:param name="title" value="${title}"/>
</jsp:include>


<div class="container">

    <jsp:include page="menu.jsp">
        <jsp:param name="menu" value="${menu}"/>
    </jsp:include>



        <jsp:include page="items.jsp">
            <jsp:param name="displays" value="${displays}"/>
            <jsp:param name="notebooks" value="${notebooks}"/>
        </jsp:include>

</div>

<body>

</body>
</html>
