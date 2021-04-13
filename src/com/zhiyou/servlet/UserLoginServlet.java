package com.zhiyou.servlet;

import com.zhiyou.model.User;
import com.zhiyou.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserLoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 编码设置
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        // 接收参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // 查询数据库
        UserService userService = new UserService();
        User user = userService.findUserByUsernameAndPassword(username, password);

        System.out.println(user);
        // 做响应
        if (user != null) {
            // 将数据存入session域中
            HttpSession session = req.getSession();
            session.setAttribute("user",user);
            req.getRequestDispatcher("/list").forward(req,resp);
        } else { // 登录失败
            // 向请求域添加错误信息
            req.setAttribute("msg","用户名或密码错误");
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        }
    }
}
