<%--
  Created by IntelliJ IDEA.
  User: ZhuYaning
  Date: 2021/4/23
  Time: 21:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <script>
        function myAction(currentPage){

            if(currentPage == undefined){
                let jump = document.getElementById("jump");
                let currentPage1 = document.getElementById("currentPage");
                let totalPage = document.getElementById("totalPage");

                if(Number(currentPage1.value)>Number(totalPage.value)){
                    currentPage1.value = totalPage.value;
                }else {
                    currentPage1.value = jump.value;
                }

                let changePageSize = document.getElementById("changePageSize");
                let pageSize = document.getElementById("pageSize");

                if(Number(changePageSize.value)>20){
                    changePageSize.value = 20;
                }else{
                    pageSize.value = changePageSize.value;
                }

            }else {
                let currentPage2 = document.getElementById("currentPage");
                currentPage2.value = currentPage;
            }
            document.forms[0].submit();
        }

        function init(){
            let currentPage1 = document.getElementById("currentPage");
            currentPage1.value = 1;
        }
    </script>
</head>
<body>
    <br><br><br>
    <form action="/book?action=query" method="post" style="align-content: center" align="center">
        <input type="hidden" id="totalPage" value="${result.totalPage}">
        <input type="hidden" value="${result.currentPage}" name="currentPage" id="currentPage">
        <input type="hidden" value="${result.pageSize}" name="pageSize" id="pageSize">
        <a href="/book?action=save" align="center">新增</a> &nbsp &nbsp
        书名：<input type="text" name="bookName" value="${qo.bookName}" onchange="init()">
        作者：<input type="text" name="authorName" value="${qo.authorName}" onchange="init()">
        分类：<select name="dirId" onchange="init()">
        <option value="">全部</option>
        <c:forEach items="${directories}" var="directory">
            <option value="${directory.id}" <c:if test="${directory.id == qo.dirId}">selected</c:if> >
                    ${directory.name}
            </option>
        </c:forEach>
    </select>
        <input type="submit" value="查询">
    </form>

    <table width="1000px" cellpadding="0" cellspacing="0" align="center" border="1px" style="text-align: center">
        <tr>
            <th>序号</th>
            <th>图书编号</th>
            <th>书名</th>
            <th>作者</th>
            <th>价格</th>
            <th>分类</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${result.resultDate}" var="book" varStatus="num">
            <tr>
                <td>${num.count}</td>
                <td>${book.sn}</td>
                <td>${book.name}</td>
                <td>${book.author}</td>
                <td>${book.price}</td>
                <td>${book.directory.name}</td>
                <td>
                    <a href="/book?action=delete&id=${book.id}">删除</a>
                    <a href="/book?action=save&id=${book.id}">修改</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <form action="/book?action=query" method="post" style="text-align: center" class="form-inline" align="center">
        <a href="javascript:void(0);" onclick="myAction(1)">首页</a>&nbsp
        <a href="javascript:void(0);" onclick="myAction(${result.prevPage})">上页</a>&nbsp
        <a href="javascript:void(0);" onclick="myAction(${result.nextPage})">下页</a>&nbsp
        <a href="javascript:void(0);" onclick="myAction(${result.totalPage})">末页</a>&nbsp
        当前第${result.currentPage}/${result.totalPage}页&nbsp&nbsp一共${result.totalCount}本书&nbsp
        跳转到：<input  id="jump" type="text" style="width: 25px" name="currentPage" value="${result.currentPage}" onchange="myAction()">&nbsp页&nbsp
        每页&nbsp<input  id="changePageSize" type="text" style="width: 25px" name="pageSize" value="${result.pageSize}" onchange="myAction()">&nbsp条数据
    </form>
</body>
</html>
