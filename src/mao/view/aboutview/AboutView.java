package mao.view.aboutview;

import mao.view.mainpage.MainView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author 豪
 * @date 2018/6/20 18:38
 */
public class AboutView extends JFrame{
    private JPanel jPanelCenter;
    private JLabel version,description,author;
    private Container container = this.getContentPane();
    private JButton returnButton;

    public AboutView() {
        init();
    }

    private void init() {
        setTitle("关于");
        jPanelCenter = new JPanel();
        jPanelCenter.setLayout(null);
        description = new JLabel("学生信息管理系统");
        author = new JLabel("作者：豪");
        version = new JLabel("版本信息：1.0");

        description.setBounds(90, 20, 120, 20);
        author.setBounds(90, 40, 120, 20);
        version.setBounds(90, 60, 120, 20);
        returnButton = new JButton("返回");
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MainView();
            }
        });
        returnButton.setBounds(90, 100, 120, 30);
        jPanelCenter.add(author);
        jPanelCenter.add(description);
        jPanelCenter.add(version);
        jPanelCenter.add(returnButton);
        container.add(jPanelCenter, "Center");
        setBounds(600, 300, 300, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        setVisible(true);
    }
}
