<%--
  Created by IntelliJ IDEA.
  User: krotsv
  Date: 25.07.17
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>cardNotChoose</title>
</head>
<body>
<form action="/sendClientData">
<h3>Please, choose card</h3>
    <input name="firstName" value="${firstName}">
    <input name="lastName" value="${lastName}">
    <input type="submit" value="Back">
</form>
</body>
</html>
