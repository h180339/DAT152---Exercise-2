<%--
  Created by IntelliJ IDEA.
  User: Eirik
  Date: 09.09.2019
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="post" class="inline">
        <button type="submit" name="Lang" value="nb_No" class="link-button">
            Norsk
        </button>
        <button type="submit" name="Lang" value="us" class="link-button">
            Engelsk
        </button>
        <button type="submit" name="Lang" value="es" class="link-button">
            Spansk
        </button>
    </form>
    <p>${text}</p>
</body>
</html>