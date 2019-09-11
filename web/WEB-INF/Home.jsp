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
    <form method="post" class="inline">
        <button type="submit" name="Lang" value="nb_No" class="link-button">
            Norsk
        </button>
        <button type="submit" name="Lang" value="us">
            Engelsk
        </button>
        <button type="submit" name="Lang" value="es">
            Spansk
        </button>
    </form>


    <h1>Kaffekopper AS</h1>
    <img src="./assets/kopp.jpeg">
    <br>
    <span>${welcomeText}<a href="./products">${prod}</a></span>
</body>
</html>
