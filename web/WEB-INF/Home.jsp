<%--
  Created by IntelliJ IDEA.
  User: Eirik
  Date: 09.09.2019
  Time: 09:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <a href="./home?lang=nb_NO">Norsk</a>&#9<a href="./home?lang=us">Engelsk</a>&#9<a href="./home?lang=es">Spansk</a>
    <h1>Kaffekopper AS</h1>
    <img src="./assets/kopp.png">
    <br>
    <span>${welcomeText}<a href="./products">${prod}</a></span>
</body>
</html>
