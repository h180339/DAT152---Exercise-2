<%--
  Created by IntelliJ IDEA.
  User: Eirik
  Date: 09.09.2019
  Time: 09:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c' %>
<html>
<head>
    <fmt:setLocale value="${langLocale}"/>
    <fmt:setBundle basename="productStrings" var="langu"/>
    <title><fmt:message key="home" bundle="${langu}"/></title>
    <meta charset="UTF-8">
</head>
<body>
    <form method="post" class="inline">
        <button type="submit" name="Lang" value="no_NO" class="link-button">
            Norsk
        </button>
        <button type="submit" name="Lang" value="en_US">
            Engelsk
        </button>
        <button type="submit" name="Lang" value="es_ES">
            Spansk
        </button>
    </form>


    <h1>Kaffekopper AS</h1>
    <img src="./assets/kopp.png">
    <br>
    <span>${welcomeText}<a href="./products">${prod}</a></span>
</body>
</html>
