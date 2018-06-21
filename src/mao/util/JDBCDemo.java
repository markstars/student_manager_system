package mao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCDemo {
    private static final String URL = "jdbc:mysql://localhost:3306/student_system";
    private static final String USER = "root";
    private static final String PASSWORLD = "123456";
    private static Connection conn = null;

    static {
        try {

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORLD);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getcConnection() {
        return conn;
    }


}
