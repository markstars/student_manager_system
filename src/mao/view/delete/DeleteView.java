package mao.view.delete;

import mao.view.mainpage.MainView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author 豪
 * @date 2018/6/20 18:38
 */
public class DeleteView extends JFrame {
    private JPanel jPanelCenter, jPanelSouth;
    private JButton deleteButton, returnButton;
    private JTextField name, sno;
    private JLabel a1, a2;
    private Container container = this.getContentPane();

    public DeleteView() {
        init();
    }

    private void init() {
        setTitle("删除学生信息");
        //姓名、学号的输入框
        jPanelCenter = new JPanel();
        jPanelCenter.setLayout(null);
        a1 = new JLabel("姓名:");
        a1.setBounds(50, 20, 50, 30);
        a2 = new JLabel("学号:");
        a2.setBounds(50, 60, 50, 30);
        jPanelCenter.add(a1);
        jPanelCenter.add(a2);
        name = new JTextField();
        sno = new JTextField();
        name.setBounds(110, 20, 120, 30);
        sno.setBounds(110, 60, 120, 30);
        jPanelCenter.add(name);
        jPanelCenter.add(sno);

        //删除按钮、返回按钮部分
        jPanelSouth = new JPanel();
        jPanelSouth.setLayout(new GridLayout(1, 2));
        deleteButton = new JButton("删除");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        jPanelSouth.add(deleteButton);
        returnButton = new JButton("返回");
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MainView();
            }
        });
        jPanelSouth.add(returnButton);

        container.add(jPanelCenter, "Center");
        container.add(jPanelSouth, "South");
        setBounds(600, 300, 300, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        setVisible(true);
    }
}
