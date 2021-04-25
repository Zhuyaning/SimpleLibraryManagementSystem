<%--
  Created by IntelliJ IDEA.
  User: ZhuYaning
  Date: 2021/4/24
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <br/>
    <br/>
    <br/>
    <a href="user?action=save">添加用户</a>
    <table width="1000px" cellpadding="0" cellspacing="0" align="center" border="1px" style="text-align: center">
        <tr>
            <th>序号</th>
            <th>用户ID</th>
            <th>用户名</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${userList}" var="user" varStatus="num">
            <tr>
                <td>${num.count}</td>
                <td>${user.uid}</td>
                <td>${user.username}</td>
                <td>
                    <a href="/user?action=delete&uid=${user.uid}">删除</a>
                    <a href="/user?action=save&uid=${user.uid}">修改</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
