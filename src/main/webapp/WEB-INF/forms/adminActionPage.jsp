<%--
  Created by IntelliJ IDEA.
  User: KrotSV
  Date: 24.07.2017
  Time: 1:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AdminActionPage</title>
</head>
<body>
<h3>Please choose client</h3>
<form action="/sendClientDataByAdmin" method="get">
    <p>Enter first name: <input type="text" name="firstName"/></p>
    <p>Enter last  name: <input type="text" name="lastName"/></p>
    <input type="submit" value="Show accounts"/>
    <p>Check card issue requests: <button formaction="/checkRequests">Check</button></p>
    <p><button type="submit" formaction="/start">Exit</button></p>
</form>
</body>
</html>
