<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>登录</title>
  </head>
  <body>
    <form action="<%=request.getContextPath()%>/user/login" method="post">
      用户名<input type="text" name="username"><br>
      密码<input type="password" name="password"><br>
      <span>
        <%
          String msg = (String) request.getAttribute("msg");
          if (msg != null) {
            out.write(msg);
          }
        %>
      </span>
      <input type="submit" value="登录"><br>
      <a href="add.jsp">注册</a>
    </form>
  </body>
</html>
