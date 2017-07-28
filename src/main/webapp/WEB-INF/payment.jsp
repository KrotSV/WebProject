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
<form action="/paymentSend">
    <p>Card number: ${sessionScope.cardNumber}; balance: ${sessionScope.balance}</p>
    <p>Please, enter sum of payment: <input type="text" name="sum" pattern="^[0-9]+(\\.[0-9]+)?$" /></p>
    <p>Please, enter payment receiver Id: <input type="text" name="receiver"/></p>
    <input type="hidden" name="cardChoose" value="${account.cardNumber}">
    <p><input type="submit" value="Pay"/>
        <input type="hidden" name="firstName" value="${sessionScope.firstName}">
        <input type="hidden" name="cardNumber" value="${sessionScope.cardNumber}">
    <input type="hidden" name="lastName" value="${sessionScope.lastName}">
    <button formaction="/sendClientData">Back</button>
    </p>
</form>
</body>
</html>
