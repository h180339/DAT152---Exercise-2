<%--
  Created by IntelliJ IDEA.
  User: Eirik
  Date: 09.09.2019
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
    <style>
        .imag {
            height: 150px;
            width: 150px;
        }
    </style>
</head>
<body>
<fmt:setLocale value="${langLocale}"/>
<fmt:setBundle basename="productStrings" var="langu"/>
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
<form method="post">
    <table>
        <tr>
            <td>
                <div>
                    <img src="${img0}" align="left" class="imag">
                    <p><fmt:message key="whiteName" bundle="${langu}"/></p>
                    <p><fmt:message key="whiteProdDesc" bundle="${langu}"/></p>
                    <p><fmt:message key="whitePrice" bundle="${langu}"/></p>
                    <p>${whitePrice}</p>
                    <button type="submit" name="cup" value="whiteCup">Add to cart</button>
                </div>
            </td>
        </tr>
        </br>
        <tr>
            <td>
                <div>
                    <img src="${img1}" align="left" class="imag">
                    <p><fmt:message key="blackName" bundle="${langu}"/></p>
                    <p><fmt:message key="blackProdDesc" bundle="${langu}"/></p>
                    <p><fmt:message key="blackPrice" bundle="${langu}"/></p>
                    <button type="submit" name="cup" value="blackCup">Add to cart</button>
                </div>
            </td>
        </tr>
        </br>
        <tr>
            <td>
                <div>
                    <img src="${img2}" align="left" class="imag">
                    <p><fmt:message key="yellowName" bundle="${langu}"/></p>
                    <p><fmt:message key="yellowProdDesc" bundle="${langu}"/></p>
                    <p><fmt:message key="yellowPrice" bundle="${langu}"/></p>
                    <button type="submit" name="cup" value="yellowCup">Add to cart</button>
                </div>
            </td>
        </tr>
    </table>
</form>
<span><a href="./home">${home}Home</a></span>
</body>
</html>
