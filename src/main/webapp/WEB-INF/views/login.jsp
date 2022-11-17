<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    <%@include file='/WEB-INF/views/css/table_dark.css' %>
</style>
<html>
<head>
    <title>Log in</title>
</head>
<body>
<form method="post" id="login" action="${pageContext.request.contextPath}/login"></form>
<h1 class="table_dark">Enter login and password:</h1>
<c:if test="${message != null}">
    <div class="error-message">
        <c:out value="${message}"/>
    </div>
</c:if>
<table border="1" class="table_dark">
    <tr>
        <td>
            <h3>Login:</h3>
        </td>
        <td>
            <input type="text" name="login" form="login" required>
        </td>
        <td>
            <h3>Password:</h3>
        </td>
        <td>
            <input type="password" name="password" form="login" required>
        </td>
        <td>
            <button type="submit" form="login">Log in</button>
        </td>
    </tr>
</table>
</body>
</html>
