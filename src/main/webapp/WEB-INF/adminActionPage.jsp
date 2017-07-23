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
<h1>Please choose client</h1>
<form action="/sendClientDataByAdmin" method="get">
    <p>Enter first name: <input type="text" name="firstName"/></p>
    <p>Enter last name:   <input type="text" name="lastName"/></p>
    <input type="submit" value="Submit"/>
</form>
</form>
</body>
</html>
