<%--
  Created by IntelliJ IDEA.
  User: KrotSV
  Date: 24.07.2017
  Time: 13:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Payment</title>
</head>
<body>
<form action="/addBalance">
    <p>Please choose type of card</p>
    <p><input type="radio" name="typeChose" value="CREDIT" checked> Credit
    <input type="radio" name="typeChose" value="DEBET" > Debet </p>
    <p>
        <input type="hidden" name="firstName" value="${sessionScope.firstName}">
        <input type="hidden" name="lastName" value="${sessionScope.lastName}">
        <input type="hidden" name="clientId" value="${sessionScope.clientId}">
        <button formaction="/sendRequestData">Request</button>
        <button formaction="/sendClientData">Back</button>
    </p>
</form>
</body>
</html>
