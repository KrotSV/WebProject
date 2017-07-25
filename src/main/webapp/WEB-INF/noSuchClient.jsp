<%--
  Created by IntelliJ IDEA.
  User: KrotSV
  Date: 24.07.2017
  Time: 0:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>noSuchUser</title>
</head>
<body>
<h3>This client does not exist.</h3>
<h3>Verify that you put correct data</h3>
<form>
    <input type="hidden" name="login" value="${sessionScope.login}">
    <input type="hidden" name="password" value="${sessionScope.password}">
    <button formaction="/sendAdminData">Back</button>
</form>
</body>
</html>
