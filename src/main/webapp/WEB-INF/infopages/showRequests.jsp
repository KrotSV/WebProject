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
<h3>Card issue requests</h3>
<form>
<table border="1">
    <tr>
        <td></td>
        <td><b>Date</b></td>
        <td><b>ClientId</b></td>
        <td><b>Type card</b></td>
        <td><b>Status</b></td>
    </tr>
    <c:forEach items="${sessionScope.requests}" var="request">
    <tr>
        <td><input type="radio" name="requestChoose" value="${request.requestId}"></td>
        <td>${request.date.time}</td>
        <td>${request.clientId}</td>
        <td>${request.typeCard}</td>
        <td>${request.approval}</td>
    </tr>
</c:forEach></table>
    <p><button type="submit" formaction="/approveRequest">Approve</button>
    <button type="submit" formaction="/rejectRequest">Reject</button>
        <input type="hidden" name="login" value="${sessionScope.login}">
        <input type="hidden" name="password" value="${sessionScope.password}">
        <button formaction="/sendAdminData">Back</button></p>

</form>
</body>
</html>
