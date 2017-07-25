<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: krotsv
  Date: 25.07.17
  Time: 18:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>History</title>
</head>
<body>
<h3>Account operation history</h3>
<p>Card number: ${account.cardNumber}; balance: ${account.balance}</p>
    <table border="1">
<tr>
    <td><b>Date</b></td>
    <td><b>Sum</b></td>
</tr>
<c:forEach items="${history}" var="transaction">
    <tr>
    <td>${transaction.date.time}</td>
    <td>${transaction.sum}</td>
    </tr>
</c:forEach></table>

</body>
</html>
