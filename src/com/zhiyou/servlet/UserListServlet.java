package com.zhiyou.servlet;

import com.zhiyou.model.User;
import com.zhiyou.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class UserListServlet extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 调用业务层查询全部数据
        ArrayList<User> list = userService.findAllUser();
        System.out.println("日志:LoginServlet.doPost() 全部用户List:"+list);
        // 将数据放入请求域
        req.setAttribute("list",list);

        // 跳转页面
        req.getRequestDispatcher("/admin.jsp").forward(req,resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
