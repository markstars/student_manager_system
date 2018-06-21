package mao.dao;

import mao.model.Student;
import mao.util.JDBCDemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
            ps.setString(1, name);
            ps.setString(2, sno);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(Student student) {
        conn = JDBCDemo.getConnection();
        String sql = "update student set department=?,hometown=?,sex=?,specialty=?,stuclass=?,tel=? where name=? and sno=?";
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

    public static String[][] list() {
        String[][] result = null;
        conn = JDBCDemo.getConnection();
        List<Student> stus = new ArrayList<Student>();
        int i = 0;

        String sql = "select * from student";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            while (rs.next()) {
                buildList(rs, stus, i);
                i++;
            }
            if (stus.size() > 0) {
                result = new String[stus.size()][9];
                for (int j = 0; j < stus.size(); j++) {
                    buildResult(result, stus, j);
                }
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }

        return result;
    }

    // 将rs记录添加到list中
    private static void buildList(ResultSet rs, List<Student> list, int i) throws SQLException {
        Student stu = new Student();
        stu.setId(i + 1);
        stu.setName(rs.getString("name"));
        stu.setDepartment(rs.getString("department"));
        stu.setSpecialty(rs.getString("specialty"));
        stu.setHometown(rs.getString("hometown"));
        stu.setStuclass(rs.getString("stuclass"));
        stu.setSex(rs.getString("sex"));
        stu.setSno(rs.getString("sno"));
        stu.setTel(rs.getString("tel"));
        list.add(stu);
    }

    // 将list中记录添加到二维数组中
    private static void buildResult(String[][] result, List<Student> stus, int j) {
        Student stu = stus.get(j);
        result[j][0] = String.valueOf(stu.getId());
        result[j][1] = stu.getName();
        result[j][2] = stu.getSno();
        result[j][3] = stu.getSex();
        result[j][4] = stu.getDepartment();
        result[j][5] = stu.getHometown();
        result[j][6] = stu.getSpecialty();
        result[j][7] = stu.getStuclass();
        result[j][8] = stu.getTel();
    }

    public static String[][] list(String name, String sno) {
        String[][] result = null;
        conn = JDBCDemo.getConnection();
        List<Student> stus = new ArrayList<Student>();
        int i = 0;

        String sql = "select * from student where name=? and sno=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, sno);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            while (rs.next()) {
                buildList(rs, stus, i);
                i++;
            }
            if (stus.size() >= 0) {
                result = new String[stus.size()][9];
                for (int j = 0; j < stus.size(); j++) {
                    buildResult(result, stus, j);
                }
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return result;
    }

    public static String[][] queryByStudent(String name, String sno) {
        conn = JDBCDemo.getConnection();
        String[][] result = null;
        if (name.length() < 0) {
            return result;
        }
        List<Student> stus = new ArrayList<Student>();
        int i = 0;
        String sql = "select * from student where name=? and sno=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, sno);
            rs = ps.executeQuery();
            while (rs.next()) {
                buildList(rs, stus, i);
                i++;
            }
            if (stus.size() >= 0) {
                result = new String[stus.size()][9];
                for (int j = 0; j < stus.size(); j++) {
                    buildResult(result, stus, j);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
