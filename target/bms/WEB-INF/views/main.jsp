<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>图书管理</title>
        <style>
            .container{
                margin:  0 auto;
                background-color: bisque;
                width: 1200px;
                height: 100%;
            }
            .mainContent{
                margin: 0 auto;
                width: 100%;
                height: 80%;
            }
            .header{
                margin: 0 auto;
                width: 1200px;
                height: 75px;
               background-color: antiquewhite;
                text-align: center;
                line-height: 75px;
                font-size: 24px;
            }
            .nav{
                background-color: cornsilk;
            }
            .booter {
                margin: 0 auto;
                width: 100%;
                height: 70px;
                background-color: antiquewhite;
                text-align: center;
                line-height: 70px;
                font-size: 24px;
                vertical-align: bottom;
            }
            ul {
                display: inline-block;
                list-style-type: none;
                margin: 0;
                padding: 0;
                overflow: hidden;
                background-color: cornsilk;
            }

            li {
                float: left;
            }

            li a {
                display: block;
                text-align: center;
                padding: 12px 14px;
                text-decoration: none;
                color: black;
            }

            li a:hover {
                background-color: burlywood;
            }
        </style>

    </head>
    <body>
        <div class="container">

            <div class="header">
                图书管理系统
            </div>

            <div class="nav">
                <ul>
                    <li><a href="http://localhost:8080/book?action=query" target="mainContent">图书管理</a></li>
                    <li><a href="http://localhost:8080/directory?action=list" target="mainContent">类别管理</a></li>
                    <li><a href="http://localhost:8080/user?action=query" target="mainContent">用户管理</a></li>
<%--                    <li><a href="">关于</a></li>--%>
                </ul>
                <ul style="float: right">
                    <li><a href="">${username}</a></li>
                    <li><a href="user?action=logout">注销登录</a></li>
                </ul>
            </div>

            <div class="mainContent">
                <iframe src="http://localhost:8080/book?action=query" name="mainContent" width="100%" height="100%" frameborder="0"></iframe>
            </div>

            <div class="booter">
                版权信息
            </div>
        </div>
    </body>
</html>
