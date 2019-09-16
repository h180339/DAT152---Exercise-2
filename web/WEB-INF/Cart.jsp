<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c' %>
<%@ taglib prefix="n" uri="/WEB-INF/customTags.tld" %>
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
    <meta charset="UTF-8">
</head>
<body>
<form method="post" class="inline">
    <button type="submit" name="Lang" value="no_NO" class="link-button">
        <fmt:message key="norsk" bundle="${lang}"/>
    </button>
    <button type="submit" name="Lang" value="en_US" class="link-button">
        <fmt:message key="engelsk" bundle="${lang}"/>
    </button>
    <button type="submit" name="Lang" value="es_ES" class="link-button">
        <fmt:message key="spansk" bundle="${lang}"/>
    </button>
</form>

<h1><fmt:message key="cartTitle" bundle="${lang}"/></h1>
<c:if test="${cartEmpty}">
    <p><fmt:message key="emptyCart" bundle="${lang}"/></p>
</c:if>
<table border="1">
    <tr>
        <th>Name</th>
        <th>Short description</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Total</th>
    </tr>

    <c:forEach items="${cart}" var="product">
        <c:if test="${not empty cart}">
            <tr>
                <td><fmt:message key="${product.pName}" bundle="${lang}"/></td>
                <td><n:shortText><fmt:message key="${product.resourceKey}" bundle="${lang}"/></n:shortText></td>
                <td><fmt:message key="${product.priceInEuro}" bundle="${lang}"/></td>
                <td><fmt:message key="amount" bundle="${lang}"/> ${product.amount} </td>
                <td><fmt:formatNumber maxFractionDigits="2" value="${product.totalPrice}" type="currency"/></td>
            </tr>
        </c:if>
    </c:forEach>
    <tr>
        <td colspan="4" align="right"><fmt:message key="totAmount" bundle="${lang}"/></td>
        <td align="right">${totalCartAmount}</td>
    </tr>
</table>
<h5>Kaffekopper AS</h5>
<span>
    <a href="./home"><fmt:message key="home" bundle="${lang}"/></a>
    <a href="./products"><fmt:message key="prod" bundle="${lang}"/></a>
</span>
<p><n:copyright/></p>
</body>
</html>