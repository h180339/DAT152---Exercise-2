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
<h3>${cartTitle}</h3>
<c:forEach items="${cart}" var="product">
    <p>${oroduct}</p>
</c:forEach>

<h1>Kaffekopper AS</h1>
<img src="./assets/kopp.png">
<br>
<span>${welcomeText}<a href="./products">${prod}</a></span>
</body>
</html>
