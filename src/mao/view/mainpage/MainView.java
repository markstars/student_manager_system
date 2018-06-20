package mao.view.mainpage;

import mao.view.aboutpage.AboutView;
import mao.view.attendancepage.AttendanceView;
import mao.view.departmentpage.DepartmentView;
import mao.view.employeepage.EmployeeView;
import mao.view.userpage.UserView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author 豪
 * @date 2018/6/19 22:52
 */
public class MainView extends JFrame {
    private JPanel jPanelCenter;
    private JButton departmentButton, employeeButton, attendanceButton, userButton, aboutButton;
    private Container container = this.getContentPane();

    public MainView() {
        init();
    }

    private void init() {

    }
}
