<%@ page import="com.zhiyou.model.User" %><%--
  Created by IntelliJ IDEA.
  User: 33475
  Date: 2021/1/23
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新</title>
</head>
<body>
<%
    User user = (User) request.getAttribute("user");
%>
<div>
<form action="<%=request.getContextPath()%>/update" method="post">

    <table>
        <!-- 隐藏id -->
        <input type="hidden" name="id" value="${user.id}">
        <tr>
            <td>用户名</td>
            <td><input type="text"  name="username" value="${user.username}"></td>
        <tr>
        <tr>
            <td>密码</td>
            <td><input type="password"  name="password" value="${user.password}"></td>
        </tr>
        <tr>
            <td>出生日期</td>
            <td><input type="Date"  name="birthday" value="${user.birthday}"></td>
        </tr>
        <tr>
            <td>手机号</td>
            <td><input type="text"  name="phone" value="${user.phone}"></td>
        </tr>
        <tr>
            <td>地址</td>
            <td><input type="text" name="address" value="${user.address}"></td>
        </tr>
    </table>
    <input type="submit" value="更新">
</form>
</div>
</body>
</html>
