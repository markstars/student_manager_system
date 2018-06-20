package mao.view.login;

import mao.view.mainpage.MainView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author 豪
 * @date 2018/6/19 22:38
 */
public class LoginView extends JFrame {
    private JPanel jPanelCenter, jPanelSouth,jPanelNorth;
    private JTextField username;
    private JPasswordField password;
    private JButton loginButton, resetButton;

    public LoginView() {
        init();
    }

    private void init() {
        this.setTitle("登陆");
        //顶部标题
        jPanelNorth = new JPanel();
        jPanelNorth.setLayout(new FlowLayout());
        jPanelNorth.add(new JLabel("人事资源管理系统"));

        //中部表单
        jPanelCenter = new JPanel();
        jPanelCenter.setLayout(new GridLayout(2, 2));
        jPanelCenter.add(new JLabel("用户名："));
        username = new JTextField();
        jPanelCenter.add(username);
        jPanelCenter.add(new JLabel("密    码："));
        password = new JPasswordField();
        jPanelCenter.add(password);

        //底部按钮
        jPanelSouth = new JPanel();
        jPanelSouth.setLayout(new GridLayout(1, 2));
        loginButton = new JButton("登陆");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MainView();
            }
        });
        jPanelSouth.add(loginButton);
        resetButton = new JButton("重置");
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                username.setText("");
                password.setText("");
            }
        });
        jPanelSouth.add(resetButton);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        add(jPanelCenter, BorderLayout.CENTER);
        add(jPanelSouth, BorderLayout.SOUTH);
        add(jPanelNorth, BorderLayout.NORTH);
        setBounds(600, 300, 300, 150);
        setVisible(true);
    }
}
