<%--
  Created by IntelliJ IDEA.
  User: krotsv
  Date: 24.07.17
  Time: 18:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BlockCard</title>
</head>
<body>
<h4>Card is blocked</h4>
<form action="/paymentSend">
    <input type="hidden" name="cardChoose" value="${account.cardNumber}">
        <input type="hidden" name="firstName" value="${sessionScope.firstName}">
        <input type="hidden" name="lastName" value="${sessionScope.lastName}">
        <button formaction="/sendClientData">Back</button>
</form>
</body>
</html>
