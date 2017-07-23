<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: KrotSV
  Date: 23.07.2017
  Time: 21:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ClientDataPage</title>
</head>
<body>
<h3>Personal account</h3>
<p>${client.firstName} ${client.lastName}</p>
<%--<p>${client.birthday}</p>--%>
<table border="1"><c:forEach items="${accounts}" var="account">
    <tr>
        <td>${account.balance}</td>
        <td>${account.status}</td>
    </tr>

</c:forEach></table>

</body>
</html>
