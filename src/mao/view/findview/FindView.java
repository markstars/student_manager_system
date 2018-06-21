package mao.view.findview;

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
    private JButton findButton, returnButton;
    private JLabel sno, name;
    private JTextField j1, j2;
    public static JTable jTable;
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
        jPanelNorth.setLayout(new GridLayout(1, 4));
        sno = new JLabel("                   姓名：");
        name = new JLabel("                  学号：");
        j1 = new JTextField();
        j2 = new JTextField();
        jPanelNorth.add(sno);
        jPanelNorth.add(j1);
        jPanelNorth.add(name);
        jPanelNorth.add(j2);

        //头部按钮
        findButton = new JButton("查询");
        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //根据学号、姓名查询
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
        jPanelNorth.add(returnButton);
        add(jPanelNorth, BorderLayout.NORTH);

        //数据呈现板
        jPanelCenter = new JPanel();
        jPanelCenter.setLayout(new GridLayout(1, 1));

        /*// 计算有多少条记录
        int count = 0;
        while(rs.next()){
            count++;
        }

        // 将查询获得的记录数据，转换成适合生成JTable的数据形式
        Object[][] info = new Object[count][9];
        count = 0;*/
        String[][] result = new String[][]{};
        myTableModel = new DefaultTableModel(result, column);
        jTable = new JTable(myTableModel);
        DefaultTableCellRenderer cr = new DefaultTableCellRenderer();
        cr.setHorizontalAlignment(JLabel.CENTER);
        jTable.setDefaultRenderer(Object.class, cr);
        //initJTable(jTable, result);

        jScrollPane = new JScrollPane(jTable);
        jPanelCenter.add(jScrollPane);
        add(jPanelCenter, BorderLayout.CENTER);

        setBounds(300, 300, 800, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
