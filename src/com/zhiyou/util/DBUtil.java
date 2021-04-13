package com.zhiyou.util;

import java.sql.*;

/**
 *  数据库工具类
 */
public class DBUtil {

    static final String url = "jdbc:mysql://localhost:3306/java28_homework";
    static final String username = "root";
    static final String password = "123456";

    // 静态代码块 : 保证该驱动最先被加载,且在内存只有一份
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 封装方法:获得连接对象
     */
    public static Connection getConnection(){

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 封装方法:关闭所有流
     */
    public static void closeAll(ResultSet rs,PreparedStatement ps,Connection conn){
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeAll(PreparedStatement ps,Connection conn){
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}