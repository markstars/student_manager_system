package mao.dao;

import mao.model.Student;
import mao.util.JDBCDemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author 豪
 * @date 2018/6/21 14:11
 */
public class StudentDao {
    private static Connection conn;
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;

    public static boolean isStudent(String name, String sno) {
        boolean flag = false;
        conn = JDBCDemo.getConnection();
        String sql = "select * from student where name=? and sno=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, sno);
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

    public static void add(Student student) {
        conn = JDBCDemo.getConnection();
        String sql = "insert into student(name,sno,department,hometown,sex,specialty,stuclass,tel) values (?,?,?,?,?,?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, student.getName());
            ps.setString(2, student.getSno());
            ps.setString(3, student.getDepartment());
            ps.setString(4, student.getHometown());
            ps.setString(5, student.getSex());
            ps.setString(6, student.getSpecialty());
            ps.setString(7, student.getStuclass());
            ps.setString(8, student.getTel());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(String name, String sno) {
        conn = JDBCDemo.getConnection();
        String sql = "delete from student where name=? and sno=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2, sno);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(Student student) {
        conn = JDBCDemo.getConnection();
        String sql="update student set department=?,hometown=?,sex=?,specialty=?,stuclass=?,tel=? where name=? and sno=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(7, student.getName());
            ps.setString(8, student.getSno());
            ps.setString(1, student.getDepartment());
            ps.setString(2, student.getHometown());
            ps.setString(3, student.getSex());
            ps.setString(4, student.getSpecialty());
            ps.setString(5, student.getStuclass());
            ps.setString(6, student.getTel());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int count() {
        int count = 0;
        conn = JDBCDemo.getConnection();
        String sql = "select *from student";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                count++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
}
