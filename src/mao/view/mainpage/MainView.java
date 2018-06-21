package mao.view.mainpage;

import mao.view.aboutview.AboutView;
import mao.view.addview.AddView;
import mao.view.delete.DeleteView;

import mao.view.findview.FindView;
import mao.view.update.UpdateView;

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
        setTitle("主界面");

        jPanelCenter = new JPanel();
        jPanelCenter.setLayout(null);

        //查询信息按钮
        departmentButton = new JButton("查询信息");
        departmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new FindView();
            }
        });
        departmentButton.setBounds(90, 20, 100, 30);
        jPanelCenter.add(departmentButton);

        //增加信息按钮
        employeeButton = new JButton("增加信息");
        employeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AddView();
            }
        });
        employeeButton.setBounds(90, 60, 100, 30);
        jPanelCenter.add(employeeButton);

        //更新信息按钮
        attendanceButton = new JButton("更新信息");
        attendanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new UpdateView();
            }
        });
        attendanceButton.setBounds(90, 100, 100, 30);
        jPanelCenter.add(attendanceButton);

        //删除信息按钮
        userButton = new JButton("删除信息");
        userButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new DeleteView();
            }
        });
        userButton.setBounds(90, 140, 100, 30);
        jPanelCenter.add(userButton);

        //关于按钮
        aboutButton = new JButton("关于");
        aboutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AboutView();
            }
        });
        aboutButton.setBounds(90, 180, 100, 30);
        jPanelCenter.add(aboutButton);
        container.add(jPanelCenter, "Center");
        setBounds(600, 300, 300, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
