package com.zhiyou.dao;

import com.zhiyou.model.User;
import com.zhiyou.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;

/**
 *  Dao : Data Access Object 数据访问对象
 */
public class UserDao {

    /**
     *  登录
     * @param username
     * @param password
     * @return
     */
    public User findUserByUsernameAndPassword(String username, String password) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;
        String sql = "select * from user where username=? and password=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            rs = ps.executeQuery();
            if(rs.next()) {
                user =  new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setBirthday(rs.getDate("birthday"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(rs, ps, conn);
        }
        return user;
    }

    /**
     *
     * @param user
     */
    public void addone(User user) {
            Connection conn = DBUtil.getConnection();
            String sql = null;
            PreparedStatement ps = null;
            try {
                sql = "insert into user (username,password,birthday,phone,address) values (?,?,?,?,?)";
                ps = conn.prepareStatement(sql);
                ps.setString(1,user.getUsername());
                ps.setString(2,user.getPassword());
                ps.setDate(3,new java.sql.Date(user.getBirthday().getTime()));
                ps.setString(4,user.getPhone());
                ps.setString(5,user.getAddress());
                int i = ps.executeUpdate();
                System.out.println("日志:UserDao.addOne 受影响行数" +i );
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBUtil.closeAll(ps,conn);
            }
    }

    public ArrayList<User> findAllUser() {
        Connection conn = DBUtil.getConnection();
        String sql = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<User> list = new ArrayList<>();
        try {
            sql = "select * from user";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setBirthday(rs.getDate("birthday"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public int deleteone(int i) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        int num = 0;
        try {
            ps = conn.prepareStatement("delete from user where id = ?");
            ps.setInt(1,i);
            num = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(ps,conn);
        }

        return num;
    }

    /**
     *  更新 ,查询单人信息
     * @param id
     * @return
     */
    public User findUserById(int id) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;
        try {
            ps = conn.prepareStatement("select * from user where id = ?");
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setBirthday(rs.getDate("birthday"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
                System.out.println(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(rs, ps,conn);
        }

        return user;
    }

    public void updateAll(User user) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("update user set username=?,password=?,birthday=?,phone=?,address=? where id=?");
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            ps.setDate(3, (Date) user.getBirthday());
            ps.setString(4,user.getPhone());
            ps.setString(5,user.getAddress());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(ps,conn);
        }

    }
}
