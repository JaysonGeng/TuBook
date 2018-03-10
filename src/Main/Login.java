package Main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import DAO.UsersDao;
import entity.Users;
import org.omg.CORBA.SetOverrideType;
import org.omg.CORBA.SetOverrideTypeHelper;


public class Login {

    UsersDao usersDao = new UsersDao();
    ArrayList<Users> list = new ArrayList<Users>();
    public JFrame jFrame = new JFrame();

    Login() {


        JPanel jPanelTop = new JPanel();
        JPanel jPanelBtom = new JPanel();
        JComboBox jComboBox = new JComboBox();


        JCheckBox rememberme = new JCheckBox("<html><p style=\"color: #666666\">&nbsp;记住密码</p></html>", false);
        rememberme.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        rememberme.setBackground(new Color(235, 242, 249));


        JCheckBox autologin = new JCheckBox("<html><p style=\"color: #666666\">&nbsp;自动登录</p></html>", false);
        autologin.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        autologin.setBackground(new Color(235, 242, 249));


        JButton register = new JButton("注册账号");
        register.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        register.setForeground(new Color(76, 165, 255));
        register.setBackground(new Color(235, 242, 249));
        register.setBorderPainted(false);

        JButton ForgotPassword = new JButton("找回密码");
        ForgotPassword.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        ForgotPassword.setForeground(new Color(76, 165, 255));
        ForgotPassword.setBackground(new Color(235, 242, 249));
        ForgotPassword.setBorderPainted(false);


        JTextField jTextField = new JTextField();
        jTextField.setText("请输入账号");
        jTextField.setForeground(new Color(127, 127, 127));
        jComboBox.setOpaque(false);
        jComboBox.setBackground(Color.white);
        jComboBox.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        jTextField.setFont(new Font("微软雅黑", Font.PLAIN, 16));

        JPasswordField jPasswordField = new JPasswordField();
        jPasswordField.setFont(new Font("微软雅黑", Font.BOLD, 30));
        Font font = new Font("微软雅黑", Font.BOLD, 30);

        JLabel title = new JLabel("图书管理系统登录");

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


        JButton login = new JButton("<html><p style=\"color: #ffffff\">登&nbsp;&nbsp;&nbsp;录</p></html>");
        login.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        login.setBackground(new Color(9, 163, 220));


//头像
        ImageIcon icon = new ImageIcon("qqtouxiang.png");
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
        title.setBounds(130, 70, 500, 100);


        jPanelTop.setBackground(new Color(0, 152, 194));
        jPanelTop.setLayout(null);
        //jPanelTop.add(Top);
        jPanelTop.add(title);
        jPanelTop.add(X);
        jPanelTop.add(min);
        min.setBounds(470, -15, 45, 50);
        X.setBounds(508, 0, 45, 40);
        jPanelTop.setSize(500, 250);

        jPanelBtom.setSize(500, 220);
        jPanelBtom.setBackground(new Color(235, 242, 249));
        jPanelBtom.setLayout(null);
        //jPanelBtom.add(user);
        jPanelBtom.add(img);
        jPanelBtom.add(img1);
        jPanelBtom.add(img2);
        //jPanelBtom.add(password);
        jPanelBtom.add(jTextField);
        jPanelBtom.add(jComboBox);
        jPanelBtom.add(jPasswordField);
        jPanelBtom.add(login);
        jPanelBtom.add(rememberme);
        jPanelBtom.add(autologin);
        jPanelBtom.add(register);
        jPanelBtom.add(ForgotPassword);

        jComboBox.setBounds(186, 32, 233, 34);
        jTextField.setBounds(186, 32, 215, 35);
        jPasswordField.setBounds(186, 64, 233, 35);
        login.setBounds(186, 150, 233, 40);
        rememberme.setBounds(186, 107, 100, 30);
        autologin.setBounds(330, 107, 100, 30);
        register.setBounds(420, 35, 100, 25);
        ForgotPassword.setBounds(420, 70, 100, 25);

        jFrame.add(jPanelTop);
        jFrame.add(jPanelBtom);
        jFrame.setTitle("图书馆管理系统 — 登录");
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
//                if(usersDao.getUsersByUserName(jTextField.getText())!=null) {
//                    Users uuu = usersDao.getUsersByUserName(jTextField.getText());
//                    jPanelBtom.remove(img);
//                    ImageIcon ic = new ImageIcon(uuu.getImage());
//                    ic.setImage(ic.getImage().getScaledInstance(110, 110, Image.SCALE_DEFAULT));
//
//                    JLabel im = new JLabel("", ic, SwingConstants.CENTER);
//                    im.setBounds(60, 25, 110, 110);
//                    jPanelBtom.add(im);
//                }
            }
        });

        jComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField.setText((String) jComboBox.getSelectedItem());
                jTextField.setFont(new Font("微软雅黑", Font.PLAIN, 19));
                jTextField.setForeground(Color.black);
                if (usersDao.getUsersByUserName(jTextField.getText()).getIsRemember() == 1) {
                    jPasswordField.setText(usersDao.getUsersByUserName((String) jComboBox.getSelectedItem()).getPassWord());
                    rememberme.setSelected(true);
                } else {
                    jPasswordField.setText("");
                    rememberme.setSelected(false);
                }

                if (usersDao.getUsersByUserName(jTextField.getText()).getImage().equals("1")) {
                    autologin.setSelected(true);
                } else {
                    autologin.setSelected(false);
                }

            }
        });

        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.setVisible(false);
                java.util.Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    public void run() {
                        Register r = new Register();
                    }
                }, 500);
            }
        });

        ForgotPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,
                        "<html><h1>自己密码都记不住？</h1><html>", "还想找回密码？", JOptionPane.PLAIN_MESSAGE);
            }
        });

/**拉取已注册用户**/
        list = usersDao.getAllUser();
        for (Users users : list) {
            jComboBox.addItem(users.getUserName());
        }

        jTextField.setText("请输入账号");
        jTextField.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        jTextField.setForeground(new Color(127, 127, 127));
/***/

        autologin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String isato = null;
                if (!jTextField.getText().equals("请输入账号")) {

                    if (autologin.isSelected()) {
                        rememberme.setSelected(true);
                    }

//                    Users u = usersDao.getUsersByUserName(jTextField.getText());
//                    if (autologin.isSelected()) {
//
//                        ArrayList<Users> userlist=usersDao.getAllUser();
//                        for(Users uu:userlist){
//                            try {
//                                usersDao.changeIsauto(uu.getUserName(),"0");
//                            } catch (Exception e1) {
//                                e1.printStackTrace();
//                            }
//                        }
//                        isato = "1";
//                        rememberme.setSelected(true);
//                        try {
//                            usersDao.changeIsRem(u.getUserName(),1);
//                        } catch (Exception e1) {
//                            e1.printStackTrace();
//                        }
//
//                    } else {
//                        isato = "0";
//
//                    }
//                    try {
//                        usersDao.changeIsauto(u.getUserName(), isato);
//                    } catch (Exception e1) {
//                        e1.printStackTrace();
//                    }
//
//                    int isrem;
//                    if(rememberme.isSelected()){
//                        isrem=1;
//                    }
//                    else isrem=0;
//                    try {
//                        usersDao.changeIsRem(u.getUserName(),isrem);
//                    } catch (Exception e1) {
//                        e1.printStackTrace();
//                    }
                }
            }
        });

        rememberme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!rememberme.isSelected()) {
                    autologin.setSelected(false);
                }
//                int isrem;
//                if(!jTextField.getText().equals("请输入账号")) {
//                    Users u = usersDao.getUsersByUserName(jTextField.getText());
//                    if(rememberme.isSelected()){
//                        isrem=1;
//                    }
//                    else {
//                        isrem=0;
//                        autologin.setSelected(false);
//                        try {
//                            usersDao.changeIsauto(u.getUserName(),"0");
//                        } catch (Exception e1) {
//                            e1.printStackTrace();
//                        }
//                    }
//                    try {
//                        usersDao.changeIsRem(u.getUserName(),isrem);
//                    } catch (Exception e1) {
//                        e1.printStackTrace();
//                    }
//                }
            }
        });
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (jTextField.getText().equals("请输入账号")) {
                    JOptionPane.showMessageDialog(null,
                            "<html><h1>请先输入账号好吗？</h1><html>", "搞事情？", JOptionPane.ERROR_MESSAGE);
                } else if (jPasswordField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null,
                            "<html><h1>没输密码也想骗我？</h1><html>", "搞事情？", JOptionPane.ERROR_MESSAGE);
                } else {
                    Users u = usersDao.getUsersByUserName(jTextField.getText());
                    if (u == null) {
                        JOptionPane.showMessageDialog(null,
                                "<html><h1>你根本没有注册过这个账号！</h1><html>", "搞事情？", JOptionPane.ERROR_MESSAGE);
                    } else if (String.valueOf(jPasswordField.getPassword()).equals(u.getPassWord())) {


                        int isrmm = 0;
                        String ato = "0";

                        if (rememberme.isSelected()) {
                            isrmm = 1;
                        }

                        if (autologin.isSelected()) {
                            ato = "1";
                        }

                        try {
                            usersDao.changeIsRem(u.getUserName(), isrmm);
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                        try {
                            usersDao.changeIsauto(u.getUserName(), ato);
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }


                        JOptionPane.showMessageDialog(null,
                                "<html><h1>登陆成功！</h1><html>", "这是一个信息框", JOptionPane.INFORMATION_MESSAGE);

                        jFrame.dispose();
                        java.util.Timer timer = new Timer();
                        timer.schedule(new TimerTask() {
                            public void run() {
                                BooksShow b = new BooksShow(u.getUserName());
                            }
                        }, 500);
                    } else JOptionPane.showMessageDialog(null,
                            "<html><h1>密码错误！</h1><html>", "搞事情？", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

    }

}
