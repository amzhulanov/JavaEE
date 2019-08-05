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

    <table class="table">
        <thead class="thead-dark">

        </thead>

        <tr>


            <td><a href=${pageContext.request.contextPath}/mainpage>Главная</a>
            </td>
            <td><a href=${pageContext.request.contextPath}/catalog>Каталог</a>
            </td>

            <c:forEach var="menu" items="${requestScope.menu}">
                <td>
                    <a href=${pageContext.request.contextPath}/${menu.value}>${pageContext.request.contextPath}/${menu.item}</a>
                </td>
            </c:forEach>

            <td><a href=${pageContext.request.contextPath}/product>Товар</a>
            </td>
            <td><a href=${pageContext.request.contextPath}/order>Заказ</a>
            </td>
            <td><a href=${pageContext.request.contextPath}/cart>Корзина</a>
            </td>
        </tr>

    </table>
</div>

<body>

</body>
</html>
