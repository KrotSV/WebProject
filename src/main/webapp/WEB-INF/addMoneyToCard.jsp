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
<form action="/payment">
    <table border="1">
        <tr>
            <td><b>CardNumber</b></td>
            <td><b>Balance</b></td>
        </tr>
        <tr>
            <td>${account.cardNumber}</td>
            <td>${account.balance}</td>
        </tr>
    </table>
    <p>Please, enter sum: <input type="text" name="sum"/></p>
    <input type="submit" value="Add"/>
</form>
</body>
</html>
