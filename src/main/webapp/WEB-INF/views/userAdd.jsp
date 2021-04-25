<%--
  Created by IntelliJ IDEA.
  User: ZhuYaning
  Date: 2021/4/20
  Time: 8:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>新增或者修改</title>
</head>
<body>
    <form action="/user?action=saveImpl" method="post">
        <input type="hidden" name="id" value="${user.uid}">
        用户名：<input type="text" name="username" placeholder="用户名" value="${user.username}" required><br/>
        密码：<input type="text" name="password" placeholder="密码" value="${user.password}" required><br/>
        <input type="submit" value="提交">
    </form>
</body>
</html>
