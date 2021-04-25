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
    <form action="/book?action=save1" method="post">
        <input type="hidden" name="id" value="${bookOne.id}">
        图书编号：<input type="text" name="sn" placeholder="图书编号" value="${bookOne.sn}" required><br/>
        书名:<input type="text" name="name" placeholder="书名" value="${bookOne.name}" required><br/>
        作者:<input type="text" name="author" placeholder="作者" value="${bookOne.author}" required><br/>
        价格:<input type="text" name="price" placeholder="价格" value="${bookOne.price}" required><br/>
        <br/>
        类别:<select name="dirId" required>
        <c:forEach items="${directories}" var="directory">
            <option value="${directory.id}" <c:if test="${directory.id == bookOne.directory.id}">selected</c:if> >${directory.name}</option>
        </c:forEach>
    </select>
        <input type="submit" value="提交">
    </form>
</body>
</html>
