package mao.view.findview;

import mao.dao.StudentDao;
import mao.service.StudentService;
import mao.view.mainpage.MainView;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author 豪
 * @date 2018/6/20 18:37
 */
public class FindView extends JFrame {
    private JPanel jPanelNorth, jPanelCenter;
    private JButton findButton, returnButton, refreshButton;
    private JLabel sno, name;
    private JTextField j1, j2;
    public static JTable jTable,jTable2;
    private JScrollPane jScrollPane;
    private DefaultTableModel myTableModel;
    private Container container = this.getContentPane();
    public static String[] column = {"id", "姓名", "学号", "性别", "院系", "籍贯", "电话", "专业", "班级"};

    public FindView() {
        init();
    }

    private void init() {
        setTitle("查询学生信息");

        //头部
        jPanelNorth = new JPanel();
        jPanelNorth.setLayout(new GridLayout(1, 5));
        name = new JLabel("               姓名：");
        sno = new JLabel("              学号：");
        j1 = new JTextField();
        j2 = new JTextField();
        jPanelNorth.add(name);
        jPanelNorth.add(j1);
        jPanelNorth.add(sno);
        jPanelNorth.add(j2);

        //头部按钮
        findButton = new JButton("查询");
        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //根据学号、姓名查询
                find();
            }
        });

        refreshButton = new JButton("刷新");
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new FindView();
            }
        });

        returnButton = new JButton("返回");
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MainView();
            }
        });
        jPanelNorth.add(findButton);
        jPanelNorth.add(refreshButton);
        jPanelNorth.add(returnButton);
        add(jPanelNorth, BorderLayout.NORTH);

//        数据呈现板
        jPanelCenter = new JPanel();
        jPanelCenter.setLayout(new GridLayout(1, 1));

        String[][] result = StudentDao.list();
        myTableModel = new DefaultTableModel(result, column);
        jTable = new JTable(myTableModel);
        DefaultTableCellRenderer cr = new DefaultTableCellRenderer();
        cr.setHorizontalAlignment(JLabel.CENTER);
        jTable.setDefaultRenderer(Object.class, cr);
        jScrollPane = new JScrollPane(jTable);
        jPanelCenter.add(jScrollPane);
        add(jPanelCenter, BorderLayout.CENTER);

        setBounds(300, 300, 800, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    private void find() {
        jPanelCenter = new JPanel();
        jPanelCenter.setLayout(new GridLayout(1, 1));
        String param1 = j1.getText();
        String param2 = j2.getText();
        String[][] result = StudentService.findOneStudent(param1,param2);
        j1.setText("");
        j2.setText("");
        myTableModel = new DefaultTableModel(result, column);
        jTable2 = new JTable(myTableModel);
        DefaultTableCellRenderer cr = new DefaultTableCellRenderer();
        cr.setHorizontalAlignment(JLabel.CENTER);
        jTable2.setDefaultRenderer(Object.class, cr);
        jScrollPane = new JScrollPane(jTable2);
        jPanelCenter.add(jScrollPane);
        add(jPanelCenter, BorderLayout.CENTER);
        setBounds(300, 300, 800, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}

