<%--
  Created by IntelliJ IDEA.
  User: JoakimJohesan
  Date: 2019-09-11
  Time: 13:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>${title}</title>
</head>
<body>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="productStrings" var="lang"/>
<h1><fmt:message key="cartTitle" bundle="${lang}"/></h1>


<c:if test="${cartEmpty} ">
    <p><fmt:message key="emptyCart" bundle="${lang}"/></p>
</c:if>
<c:forEach items="${cart}" var="product">
    <c:if test="${not empty cart} ">
        <li><fmt:message key="${product.pName}" bundle="${lang}"/></li>
    </c:if>
</c:forEach>

<h5>Kaffekopper AS</h5>
</body>
</html>