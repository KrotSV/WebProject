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
    <p>Card number: ${sessionScope.cardChoose}; balance: ${sessionScope.account.balance}</p>
    <p>Please, enter sum: <input type="text" name="sum" pattern="^[0-9]+(\\.[0-9]+)?$"/></p>
    <input type="hidden" name="cardNumber" value="${cardNumber}">
    <p><input type="submit" value="Add" pattern="^[0-9]+(\\.[0-9]+)?$"/>
        <input type="hidden" name="firstName" value="${sessionScope.firstName}">
        <input type="hidden" name="lastName" value="${sessionScope.lastName}">
        <button formaction="/sendClientData">Back</button>
    </p>
</form>
</body>
</html>
