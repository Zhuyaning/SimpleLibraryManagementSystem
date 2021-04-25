<%--
  Created by IntelliJ IDEA.
  User: ZhuYaning
  Date: 2021/4/24
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>

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
            width: 100%;
            height: 45px;
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

            </div>
            <div class="mainContent">
                <form action="user?action=loginImpl"  method="post">
                    <table align="center" valign="center">
                        <tr>
                            <th>用户名：</th>
                            <td><input name="username" type="text"></td>
                        </tr>

                        <tr>
                            <th>密码：</th>
                            <td><input type="password" name="password"></td>
                        </tr>

                        <tr>
                            <th></th>
                            <td><input type="submit" value="登录"></td>
                        </tr>
                    </table>
                </form>
            </div>

            <div class="booter">
                版权信息
            </div>
        </div>

    </body>
</html>
