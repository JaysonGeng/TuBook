package Main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

import DAO.UsersDao;
import entity.Users;
import org.omg.CORBA.SetOverrideType;
import org.omg.CORBA.SetOverrideTypeHelper;
import java.util.Timer;
import java.util.TimerTask;

public class Register {

    UsersDao usersDao = new UsersDao();
    ArrayList<Users> list = new ArrayList<Users>();

    Register() {

        JFrame jFrame = new JFrame();
        JPanel jPanelTop = new JPanel();
        JPanel jPanelBtom = new JPanel();


        JTextField jTextField = new JTextField();
        jTextField.setText("请输入账号");
        jTextField.setForeground(new Color(127, 127, 127));
        jTextField.setFont(new Font("微软雅黑", Font.PLAIN, 16));


        JTextField jPasswordField = new JTextField();
        jPasswordField.setText("请输入密码");
        jPasswordField.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        jPasswordField.setForeground(new Color(127, 127, 127));

        JTextField jPasswordField2 = new JTextField();
        jPasswordField2.setText("请再次确认密码");
        jPasswordField2.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        jPasswordField2.setForeground(new Color(127, 127, 127));


        JLabel title = new JLabel("用户注册");


        JButton X = new JButton("<html><h2 style=\"color: #ffffff\">X</h2></html>");
        X.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 10));
        X.setBackground(Color.red);
        X.setBorderPainted(false);
        X.setOpaque(false);

        JButton min = new JButton("<html><h1 style=\"color: #ffffff\">_</h1></html>");
        min.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 10));
        min.setBackground(Color.red);
        min.setBorderPainted(false);
        min.setOpaque(false);


        JButton login = new JButton("<html><p style=\"color: #ffffff\">注&nbsp;&nbsp;&nbsp;册</p></html>");
        login.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        login.setBackground(new Color(9, 163, 220));


//头像
        ImageIcon icon = new ImageIcon("img.jpg");
        icon.setImage(icon.getImage().getScaledInstance(110, 110, Image.SCALE_DEFAULT));

        JLabel img = new JLabel("", icon, SwingConstants.CENTER);
        img.setBounds(60, 25, 110, 110);

//z左右下角
        ImageIcon icon1 = new ImageIcon("duozhanghao.png");
        icon1.setImage(icon1.getImage().getScaledInstance(48, 44, Image.SCALE_DEFAULT));

        JLabel img1 = new JLabel("", icon1, SwingConstants.CENTER);
        img1.setBounds(10, 170, 48, 44);

        ImageIcon icon2 = new ImageIcon("erweima.png");
        icon2.setImage(icon2.getImage().getScaledInstance(48, 48, Image.SCALE_DEFAULT));

        JLabel img2 = new JLabel("", icon2, SwingConstants.CENTER);
        img2.setBounds(495, 165, 48, 48);
//

        jFrame.setLayout(new GridLayout(2, 1));
        jFrame.setSize(550, 435);
        jFrame.setLocationRelativeTo(null);
        jFrame.setUndecorated(true);

        title.setFont(new Font("微软雅黑", Font.BOLD, 40));
        title.setForeground(Color.white);
        title.setBounds(200, 70, 500, 100);


        jPanelTop.setBackground(new Color(0, 152, 194));
        jPanelTop.setLayout(null);

        jPanelTop.add(title);
        jPanelTop.add(X);
        jPanelTop.add(min);
        min.setBounds(470, -15, 45, 50);
        X.setBounds(508, 0, 45, 40);
        jPanelTop.setSize(500, 250);

        jPanelBtom.setSize(500, 220);
        jPanelBtom.setBackground(new Color(235, 242, 249));
        jPanelBtom.setLayout(null);

        jPanelBtom.add(img);
        jPanelBtom.add(img1);
        jPanelBtom.add(img2);

        jPanelBtom.add(jTextField);
        jPanelBtom.add(jPasswordField);
        jPanelBtom.add(jPasswordField2);
        jPanelBtom.add(login);


        jTextField.setBounds(186, 32, 233, 35);
        jPasswordField.setBounds(186, 65, 233, 35);
        jPasswordField2.setBounds(186, 98, 233, 35);
        login.setBounds(186, 150, 233, 40);


        jFrame.add(jPanelTop);
        jFrame.add(jPanelBtom);
        jFrame.setTitle("图书馆管理系统 — 注册");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);

        min.addActionListener(e -> jFrame.setExtendedState(JFrame.ICONIFIED));
        X.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                X.setOpaque(true);
                System.exit(0);
            }
        });

        jTextField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

                if (jTextField.getText().equals("请输入账号")) {
                    jTextField.setText("");
                    jTextField.setFont(new Font("微软雅黑", Font.PLAIN, 19));
                    jTextField.setForeground(Color.black);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (jTextField.getText().equals("")) {
                    jTextField.setText("请输入账号");
                    jTextField.setFont(new Font("微软雅黑", Font.PLAIN, 16));
                    jTextField.setForeground(new Color(127, 127, 127));
                }
            }
        });

        jPasswordField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

                if (jPasswordField.getText().equals("请输入密码")) {
                    jPasswordField.setText("");
                    jPasswordField.setFont(new Font("微软雅黑", Font.PLAIN, 19));
                    jPasswordField.setForeground(Color.black);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (jPasswordField.getText().equals("")) {
                    jPasswordField.setText("请输入密码");
                    jPasswordField.setFont(new Font("微软雅黑", Font.PLAIN, 16));
                    jPasswordField.setForeground(new Color(127, 127, 127));
                }
            }
        });

        jPasswordField2.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

                if (jPasswordField2.getText().equals("请再次确认密码")) {
                    jPasswordField2.setText("");
                    jPasswordField2.setFont(new Font("微软雅黑", Font.PLAIN, 19));
                    jPasswordField2.setForeground(Color.black);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (jPasswordField2.getText().equals("")) {
                    jPasswordField2.setText("请再次确认密码");
                    jPasswordField2.setFont(new Font("微软雅黑", Font.PLAIN, 16));
                    jPasswordField2.setForeground(new Color(127, 127, 127));
                }
            }
        });

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jTextField.getText().equals("请输入账号")) {
                    JOptionPane.showMessageDialog(null,
                            "<html><h1>请先输入账号好吗？</h1><html>", "搞事情？", JOptionPane.ERROR_MESSAGE);
                } else if (jPasswordField.getText().equals("请输入密码")) {
                    JOptionPane.showMessageDialog(null,
                            "<html><h1>没输密码也想骗我？</h1><html>", "搞事情？", JOptionPane.ERROR_MESSAGE);
                } else if (jPasswordField2.getText().equals("请再次确认密码")) {
                    JOptionPane.showMessageDialog(null,
                            "<html><h1>不再确认一下密码？</h1><html>", "搞事情？", JOptionPane.ERROR_MESSAGE);
                } else if (!jPasswordField.getText().equals(jPasswordField2.getText())) {
                    JOptionPane.showMessageDialog(null,
                            "<html><h1>看着你都要把密码输错？</h1><html>", "搞事情？", JOptionPane.ERROR_MESSAGE);
                } else if (usersDao.getUsersByUserName(jTextField.getText()) != null) {
                    JOptionPane.showMessageDialog(null,
                            "<html><h1>该账号已被注册！</h1><html>", "搞事情？", JOptionPane.ERROR_MESSAGE);
                } else
                    try {
                        usersDao.insertDate(jTextField.getText(), jPasswordField.getText(), "0", 0);
                        JOptionPane.showMessageDialog(null,
                                "<html><h1>注册成功！</h1><html>", "我觉得OK", JOptionPane.INFORMATION_MESSAGE);
                        jFrame.dispose();
                        Timer timer=new Timer();
                        timer.schedule(new TimerTask(){
                            public void run(){
                                Login login =new Login();}},500);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
            }
        });
    }
    public static void main(String[] args){

        Register login11 =new Register();
    }
}
