<%--
  Created by IntelliJ IDEA.
  User: Eirik
  Date: 09.09.2019
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c' %>
<html>
<head>
    <fmt:setLocale value="${langLocale}"/>
    <fmt:setBundle basename="productStrings" var="langu"/>
    <title><fmt:message key="prod" bundle="${langu}"/></title>
    <meta charset="UTF-8">
    <style>
        .imag {
            height: 150px;
            width: 150px;
        }
    </style>
</head>
<body>
<form method="post" class="inline">
    <button type="submit" name="Lang" value="no_NO" class="link-button">
        Norsk
    </button>
    <button type="submit" name="Lang" value="en_US" class="link-button">
        Engelsk
    </button>
    <button type="submit" name="Lang" value="es_ES" class="link-button">
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
                    <span>
                        <fmt:message key="description" bundle="${langu}"/>
                        <fmt:message key="whiteProdDesc" bundle="${langu}"/>
                    </span>
                    <p><fmt:message key="whitePrice" bundle="${langu}"/></p>
                    <p>${whitePrice}</p>
                    <button type="submit" name="cup" value="whiteName">Add to cart</button>
                </div>
            </td>
        </tr>
        </br>
        <tr>
            <td>
                <div>
                    <img src="${img1}" align="left" class="imag">
                    <p><fmt:message key="blackName" bundle="${langu}"/></p>
                    <span>
                        <fmt:message key="description" bundle="${langu}"/>
                        <fmt:message key="blackProdDesc" bundle="${langu}"/>
                    </span>
                    <p><fmt:message key="blackPrice" bundle="${langu}"/></p>
                    <button type="submit" name="cup" value="blackName">Add to cart</button>
                </div>
            </td>
        </tr>
        </br>
        <tr>
            <td>
                <div>
                    <img src="${img2}" align="left" class="imag">
                    <p><fmt:message key="yellowName" bundle="${langu}"/></p>
                    <span>
                        <fmt:message key="description" bundle="${langu}"/>
                        <fmt:message key="yellowProdDesc" bundle="${langu}"/>
                    </span>
                    <p><fmt:message key="yellowPrice" bundle="${langu}"/></p>
                    <button type="submit" name="cup" value="yellowName">Add to cart</button>
                </div>
            </td>
        </tr>
    </table>
</form>
<span>
    <a href="./home"><fmt:message key="home" bundle="${langu}"/></a>
    <a href="./cart"><fmt:message key="cart" bundle="${langu}"/></a>
</span>
</body>
</html>
