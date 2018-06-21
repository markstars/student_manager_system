package mao.dao;

import mao.util.JDBCDemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author 豪
 * @date 2018/6/21 10:37
 */
public class AdminDao {
    private static Connection conn;
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;

    public static boolean isfindManager(String username, String password) {
        boolean flag = false;
        conn = JDBCDemo.getConnection();
        String sql = "select * from admin where username=? and password=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                flag = true;
            } else {
                flag = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
}
