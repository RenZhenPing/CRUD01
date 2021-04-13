<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
<link href="<%=request.getContextPath()%>/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
</head>
<body>
<div class="col-md-6">
<form action="<%=request.getContextPath()%>/user/add" method="post">
    <table class="table table-bordered">
        <tr>
            <td>用户名</td>
                <td><input type="text" name="username"></td>
        <tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password"><br></td>
       </tr>
        <tr>
            <td>出生日期</td>
            <td><input type="Date" name="birthday"><br></td>
        </tr>
        <tr>
            <td>手机号</td>
            <td><input type="text" name="phone"><br></td>
        </tr>
        <tr>
            <td>地址</td>
            <td><input type="text" name="address"><br></td>
        </tr>
    </table>
    <input type="submit" value="注册"><br>
    <input type="reset" value="重置"><br>
</form>
</div>
</body>
</html>
