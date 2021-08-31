<%--
  Created by IntelliJ IDEA.
  User: 明艳
  Date: 2021/8/29
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <c:forEach items="${list}" var="user">
        <tr>
            <td>${user.username} <td>
            <td><a href="/b.do?list=${user.roomList}">详情</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
