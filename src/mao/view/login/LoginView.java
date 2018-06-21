package mao.view.login;

import mao.service.AdminService;
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
    private JPanel jPanelCenter, jPanelSouth, jPanelNorth;
    private JTextField username;
    private JPasswordField password;
    private JButton loginButton, resetButton;
    private JLabel a1, a2;
    private Container container = this.getContentPane();

    public LoginView() {
        init();
    }

    private void init() {
        this.setTitle("登陆");
        //顶部标题
        jPanelNorth = new JPanel();
        jPanelNorth.setLayout(new FlowLayout());
        jPanelNorth.add(new JLabel("系统管理员登陆"));
        container.add(jPanelNorth, "North");

        //中部表单
        jPanelCenter = new JPanel();
        jPanelCenter.setLayout(null);
        a1 = new JLabel("用户名:");
        a1.setBounds(50, 20, 50, 30);
        a2 = new JLabel("密    码:");
        a2.setBounds(50, 60, 50, 30);
        jPanelCenter.add(a1);
        jPanelCenter.add(a2);
        username = new JTextField();
        password = new JPasswordField();
        username.setBounds(110, 20, 120, 30);
        password.setBounds(110, 60, 120, 30);
        jPanelCenter.add(username);
        jPanelCenter.add(password);

        //底部按钮
        jPanelSouth = new JPanel();
        jPanelSouth.setLayout(new GridLayout(1, 2));
        loginButton = new JButton("登陆");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                AdminService.checkManager(username.getText().trim(),password.getText().trim());
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

        container.add(jPanelCenter, "Center");
        container.add(jPanelSouth, "South");
        setBounds(600, 300, 300, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        setVisible(true);
    }

}
