package com.zhiyou.service;

import com.zhiyou.dao.UserDao;
import com.zhiyou.model.User;

import java.util.ArrayList;

public class UserService {

        UserDao userDao = new UserDao();

    public void addone(User user) {
        userDao.addone(user);
    }

    public User findUserByUsernameAndPassword(String username, String password) {
        // 调用Dao查询数据库
        User user = userDao.findUserByUsernameAndPassword(username, password);

        return user;
    }

    public ArrayList<User> findAllUser() {

        return userDao.findAllUser();
    }

    public boolean deleteone(int id) {
        int num = userDao.deleteone(id);
        if (num > 0 ) {
            return true;
        }
        return false;
    }

    public User findUserById(int id) {
       return userDao.findUserById(id);

    }

    public void updateAll(User user) {
        userDao.updateAll(user);
    }
}
