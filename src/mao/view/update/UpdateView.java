package mao.view.update;

import mao.view.mainpage.MainView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author 豪
 * @date 2018/6/20 18:38
 */
public class UpdateView extends JFrame{
    private JPanel jPanelCenter, jPanelSouth;
    private JButton updateButton, returnButton;
    private JTextField name, sno, sex,department, hometown, tel, specialty, jlclass;

    public UpdateView() {
        init();
    }

    private void init() {
        setTitle("修改学生信息");
        // 中部表单
        jPanelCenter = new JPanel();
        jPanelCenter.setLayout(new GridLayout(8, 2));
        jPanelCenter.add(new JLabel("姓名"));
        name = new JTextField();
        jPanelCenter.add(name);
        jPanelCenter.add(new JLabel("学号"));
        sno = new JTextField();
        jPanelCenter.add(sno);
        jPanelCenter.add(new JLabel("性别"));
        sex = new JTextField();
        jPanelCenter.add(sex);
        jPanelCenter.add(new JLabel("院系"));
        department = new JTextField();
        jPanelCenter.add(department);
        jPanelCenter.add(new JLabel("籍贯"));
        hometown = new JTextField();
        jPanelCenter.add(hometown);
        jPanelCenter.add(new JLabel("班级"));
        jlclass = new JTextField();
        jPanelCenter.add(jlclass);
        jPanelCenter.add(new JLabel("专业"));
        specialty = new JTextField();
        jPanelCenter.add(specialty);
        jPanelCenter.add(new JLabel("联系方式"));
        tel = new JTextField();
        jPanelCenter.add(tel);

        //底部按钮
        jPanelSouth = new JPanel();
        jPanelSouth.setLayout(new GridLayout(1, 2));
        updateButton = new JButton("修改");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        jPanelSouth.add(updateButton);
        returnButton = new JButton("返回");
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MainView();
            }
        });
        jPanelSouth.add(returnButton);

        add(jPanelCenter,BorderLayout.CENTER);
        add(jPanelSouth, BorderLayout.SOUTH);

        setBounds(600,300,400,300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        setVisible(true);
    }
}
