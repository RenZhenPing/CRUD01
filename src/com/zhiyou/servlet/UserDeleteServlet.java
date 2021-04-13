package com.zhiyou.servlet;

import com.zhiyou.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserDeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 接收参数
        String ids = req.getParameter("id");
        int id = Integer.parseInt(ids);

        // 调用Service层
        UserService userService = new UserService();
        boolean result =  userService.deleteone(id);

        // 删除完返回需要重定向
        resp.sendRedirect(req.getContextPath()+"/list");
    }
}
