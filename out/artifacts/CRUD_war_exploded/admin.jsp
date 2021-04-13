<%@ page import="com.zhiyou.model.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人中心</title>
</head>
<body>
    <h1>登陆成功</h1>
    <table>
        <tr>
            <td>序号</td>
            <td>用户名</td>
            <td>密码</td>
            <td>出生日期</td>
            <td>电话</td>
            <td>地址</td>
        </tr>
        <%
            User user = (User) session.getAttribute("user");
        %>
        <tr>
            <td><%=user.getId()%></td>
            <td><%=user.getUsername()%></td>
            <td><%=user.getPassword()%></td>
            <td><%=user.getBirthday()%></td>
            <td><%=user.getPhone()%></td>
            <td><%=user.getAddress()%></td>
        </tr>
    </table>
    <hr>
    <h2>全部用户</h2>
        <%
            ArrayList<User> list = (ArrayList<User>) request.getAttribute("list");
        %>
    <table class="table table-bordered">
        <tr>
            <td>序号</td>
            <td>用户名</td>
            <td>密码</td>
            <td>出生日期</td>
            <td>电话</td>
            <td>地址</td>
            <td>操作</td>
        </tr>
        <%
            for (int i = 0; i <list.size() ; i++) {
                User u = list.get(i);
                out.write("<tr>");
                out.write("<td>"+u.getId()+"</td>");
                out.write("<td>"+u.getUsername()+"</td>");
                out.write("<td>"+u.getPassword()+"</td>");
                out.write("<td>"+u.getBirthday()+"</td>");
                out.write("<td>"+u.getPhone()+"</td>");
                out.write("<td>"+u.getAddress()+"</td>");
                String path = request.getContextPath();
                out.write("<td><a href='#' onclick='return isDelete("+u.getId()+");'>删除</a></td>");
                out.write("<td><a href='"+path+"/update?id="+u.getId()+"'>更新</a></td>");
                out.write("</tr>");
            }
        %>
    </table>
<div>
    <script type="text/javascript">
        // 删除的二次确认
        function isDelete(id) {
            var result = confirm("是否删除")
            if(result) {
                // 发送删除请求
                window.location = "http://localhost:8080<%=request.getContextPath()%>/delete?id="+id;
            }
            return false;
        }
    </script>
</div>
</body>
</html>
