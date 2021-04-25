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
    <form action="/directory?action=save1" method="post">
        <input type="hidden" name="id" value="${directory.id}">
        类别名：<input type="text" name="name" placeholder="类别名" value="${directory.name}" required><br/>
        描述：<input type="text" name="describes" placeholder="描述" value="${directory.describes}" required><br/>
        <input type="submit" value="提交">
    </form>
</body>
</html>
