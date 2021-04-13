package com.zhiyou.servlet;

import com.zhiyou.model.User;
import com.zhiyou.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserUpdateServlet extends HttpServlet {

       private UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 接收数据
        String ids = req.getParameter("id");
        int id = Integer.parseInt(ids);
        System.out.println(id );

        // 调用Service层
        User user = userService.findUserById(id);
//        System.out.println(user);

        // 传入请求域
        req.setAttribute("user",user);

        req.getRequestDispatcher("/update.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 设置编码格式
        req.setCharacterEncoding("utf-8");

        // 接收参数
        String ids = req.getParameter("id");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String birthdaystr = req.getParameter("birthday");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");

        // 封装数据
        User user = new User();
        int id = Integer.parseInt(ids);
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        Date birthday = null;
        try {
            birthday = new SimpleDateFormat("yyyy-MM-dd").parse(birthdaystr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.setBirthday(birthday);
        user.setPhone(phone);
        user.setAddress(address);

        // 调用Service层
        userService.updateAll(user);

        // 回到原来页面,需要重写查询
        req.getRequestDispatcher("/list").forward(req,resp);


    }
}
