<%--
  Created by IntelliJ IDEA.
  User: KrotSV
  Date: 26.07.2017
  Time: 0:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>notEnoughMoney</title>
</head>
<body>
<form>
    <h3>Not enough money</h3>
    <input type="hidden" name="cardChoose" value="${sessionScope.cardChoose}">
    <button formaction="/payCard">Back</button>
</form>
</body>
</html>
