<%--
  Created by IntelliJ IDEA.
  User: KrotSV
  Date: 23.07.2017
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AdminLoginPage</title>
</head>
<body>
<h1>Please enter your login and password</h1>
<form action="/sendAdminData" method="get">
    <p>login:    <input type="text" name="login"/></p>
    <p>Password: <input type="text" name="password"/></p>
    <p><input type="submit" value="Login"/>   <button type="submit" formaction="/start">Exit</button></p>
</form>
</body>
</html>
