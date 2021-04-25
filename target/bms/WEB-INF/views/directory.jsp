<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>类别管理</title>
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
    <form action="/directory?action=list" method="post" style="align-content: center" align="center">
        <input type="hidden" id="totalPage" value="${result.totalPage}">
        <input type="hidden" value="${result.currentPage}" name="currentPage" id="currentPage">
        <input type="hidden" value="${result.pageSize}" name="pageSize" id="pageSize">
        <a href="/directory?action=save" align="center">新增</a> &nbsp &nbsp
        关键字：<input type="text" name="keyWords" value="${qo.keyWords}" onchange="init()">
        <input type="submit" value="查询">
    </form>

    <table width="1000px" cellpadding="0" cellspacing="0" align="center" border="1px" style="text-align: center">
        <tr>
            <th>序号</th>
            <th>类别名</th>
            <th>描述</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${result.resultDate}" var="directory" varStatus="num">
            <tr>
                <td>${num.count}</td>
                <td>${directory.name}</td>
                <td>${directory.describes}</td>
                <td>
                    <a href="/directory?action=delete&id=${directory.id}">删除</a>
                    <a href="/directory?action=save&id=${directory.id}">修改</a>
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