<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c' %>
<%--
  Created by IntelliJ IDEA.
  User: JoakimJohesan
  Date: 2019-09-11
  Time: 13:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <fmt:setLocale value="${langLocale}"/>
    <fmt:setBundle basename="productStrings" var="lang"/>
    <title><fmt:message key="cartTitle" bundle="${lang}"/></title>
</head>
<body>
<form method="post" class="inline">
    <button type="submit" name="Lang" value="nb" class="link-button">
        Norsk
    </button>
    <button type="submit" name="Lang" value="us" class="link-button">
        Engelsk
    </button>
    <button type="submit" name="Lang" value="es" class="link-button">
        Spansk
    </button>
</form>

<h1><fmt:message key="cartTitle" bundle="${lang}"/></h1>
<c:if test="${cartEmpty}">
    <p><fmt:message key="emptyCart" bundle="${lang}"/></p>
</c:if>
<c:forEach items="${cart}" var="product">
    <c:if test="${not empty cart}">
        <li><fmt:message key="${product.pName}" bundle="${lang}"/> | <fmt:message key="${product.priceInEuro}" bundle="${lang}"/> | <fmt:message key="${product.resourceKey}" bundle="${lang}"/> |
            <fmt:message key="amount" bundle="${lang}"/> ${product.amount}</li>
    </c:if>
</c:forEach>

<h5>Kaffekopper AS</h5>
<span>
    <a href="./home"><fmt:message key="home" bundle="${lang}"/></a>
    <a href="./products"><fmt:message key="prod" bundle="${lang}"/></a>
</span>
</body>
</html>