package mao.service;

import mao.dao.AdminDao;
import mao.view.login.LoginView;
import mao.view.mainpage.MainView;

import javax.swing.*;

/**
 * @author 豪
 * @date 2018/6/21 10:46
 */
public class AdminService {
    public static void checkManager(String username, String password) {
        if ((!(username.equals(""))) && (!(password.equals("")))) {
//            if(((username.length()<1000000000)&&(username.length()>=100000))){
            if (AdminDao.isfindManager(username, password)) {
                new MainView();
            } else {
                JOptionPane.showMessageDialog(null, "管理员身份验证失败，请重新验证身份！");
                new LoginView();
            }
//            }else {
//                JOptionPane.showMessageDialog(null,"用户名的长度为9位以上");
//                new LoginView();
//            }
        } else {
            JOptionPane.showMessageDialog(null, "请输入用户名和密码");
            new LoginView();
        }
    }
}
