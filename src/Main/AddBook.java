package Main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

import DAO.BooksDao;
import DAO.UsersDao;
import entity.Users;
import org.omg.CORBA.SetOverrideType;
import org.omg.CORBA.SetOverrideTypeHelper;

import java.util.Timer;
import java.util.TimerTask;

public class AddBook {

    BooksDao booksDao = new BooksDao();
    ArrayList<Users> list = new ArrayList<Users>();
    private String fileName;
    private String filePath;

    AddBook(String UserName) {

        JFrame jFrame = new JFrame();
        JPanel jPanelTop = new JPanel();
        JPanel jPanelBtom = new JPanel();


        JTextField jTextField = new JTextField();
        jTextField.setText("请输入书名");
        jTextField.setForeground(new Color(127, 127, 127));
        jTextField.setFont(new Font("微软雅黑", Font.PLAIN, 16));


        JTextField jPasswordField = new JTextField();
        jPasswordField.setText("请输入作者名");
        jPasswordField.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        jPasswordField.setForeground(new Color(127, 127, 127));

        JTextField jPasswordField2 = new JTextField();
        jPasswordField2.setText("请输入出版社");
        jPasswordField2.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        jPasswordField2.setForeground(new Color(127, 127, 127));

        JTextField jPasswordField3 = new JTextField();
        jPasswordField3.setText("请输入价格");
        jPasswordField3.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        jPasswordField3.setForeground(new Color(127, 127, 127));


        JLabel title = new JLabel("添加新书");
        title.setFont(new Font("微软雅黑", Font.BOLD, 18));
        title.setForeground(Color.white);

        JButton X = new JButton("<html><h2 style=\"color: #ffffff\">x</h2></html>");
        X.setFont(new Font("微软雅黑", Font.BOLD, 5));
        X.setBackground(Color.red);
        X.setBorderPainted(false);
        X.setOpaque(false);


        JButton login = new JButton("<html><p style=\"color: #ffffff\">添&nbsp;&nbsp;加&nbsp;&nbsp;新&nbsp;&nbsp;书</p></html>");
        login.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        login.setBackground(new Color(9, 163, 220));

        JButton Import = new JButton("<html><p style=\"color: #ffffff\">从&nbsp;&nbsp;文&nbsp;&nbsp;件&nbsp;&nbsp;导&nbsp;&nbsp;入</p></html>");
        Import.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        Import.setBackground(new Color(9, 163, 220));

        JButton back = new JButton("<html><p style=\"color: #ffffff\">返&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;回</p></html>");
        back.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        back.setBackground(new Color(9, 163, 220));


//头像
        ImageIcon icon = new ImageIcon("newbook.png");
        icon.setImage(icon.getImage().getScaledInstance(170, 170, Image.SCALE_DEFAULT));

        JLabel img = new JLabel("", icon, SwingConstants.CENTER);
        img.setBounds(55, 75, 180, 180);

        ImageIcon icon1 = new ImageIcon("weiruan.png");
        icon1.setImage(icon1.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));

        JLabel img1 = new JLabel("", icon1, SwingConstants.CENTER);
        img1.setBounds(10, 5, 25, 25);


        jPanelTop.setBackground(new Color(0, 152, 194));
        jPanelTop.setLayout(null);

        jPanelTop.add(img1);
        jPanelTop.add(title);
        jPanelTop.add(X);


        jFrame.setSize(550, 435);
        jFrame.setLocationRelativeTo(null);
        jFrame.setUndecorated(true);

        title.setForeground(Color.white);
        title.setBounds(45, 0, 600, 35);


        X.setBounds(508, 0, 45, 40);


        jPanelTop.setBounds(0, 0, 700, 35);


        jPanelBtom.setSize(500, 220);
        jPanelBtom.setBackground(new Color(235, 242, 249));
        jPanelBtom.setLayout(null);

        jPanelBtom.add(img);


        jPanelBtom.add(jTextField);
        jPanelBtom.add(jPasswordField);
        jPanelBtom.add(jPasswordField2);
        jPanelBtom.add(jPasswordField3);
        jPanelBtom.add(login);
        jPanelBtom.add(Import);
        jPanelBtom.add(back);


        jTextField.setBounds(245, 95, 233, 35);
        jPasswordField.setBounds(245, 130, 233, 35);
        jPasswordField2.setBounds(245, 165, 233, 35);
        jPasswordField3.setBounds(245, 200, 233, 35);
        login.setBounds(65, 265, 412, 40);
        Import.setBounds(65, 320, 412, 40);
        back.setBounds(65, 375, 412, 40);


        jFrame.add(jPanelTop);
        jFrame.add(jPanelBtom);
        jFrame.setTitle("图书馆管理系统 — 注册");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);

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

                if (jTextField.getText().equals("请输入书名")) {
                    jTextField.setText("");
                    jTextField.setFont(new Font("微软雅黑", Font.PLAIN, 19));
                    jTextField.setForeground(Color.black);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (jTextField.getText().equals("")) {
                    jTextField.setText("请输入书名");
                    jTextField.setFont(new Font("微软雅黑", Font.PLAIN, 16));
                    jTextField.setForeground(new Color(127, 127, 127));
                }
            }
        });

        jPasswordField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

                if (jPasswordField.getText().equals("请输入作者名")) {
                    jPasswordField.setText("");
                    jPasswordField.setFont(new Font("微软雅黑", Font.PLAIN, 19));
                    jPasswordField.setForeground(Color.black);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (jPasswordField.getText().equals("")) {
                    jPasswordField.setText("请输入作者名");
                    jPasswordField.setFont(new Font("微软雅黑", Font.PLAIN, 16));
                    jPasswordField.setForeground(new Color(127, 127, 127));
                }
            }
        });

        jPasswordField2.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

                if (jPasswordField2.getText().equals("请输入出版社")) {
                    jPasswordField2.setText("");
                    jPasswordField2.setFont(new Font("微软雅黑", Font.PLAIN, 19));
                    jPasswordField2.setForeground(Color.black);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (jPasswordField2.getText().equals("")) {
                    jPasswordField2.setText("请输入出版社");
                    jPasswordField2.setFont(new Font("微软雅黑", Font.PLAIN, 16));
                    jPasswordField2.setForeground(new Color(127, 127, 127));
                }
            }
        });

        jPasswordField3.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

                if (jPasswordField3.getText().equals("请输入价格")) {
                    jPasswordField3.setText("");
                    jPasswordField3.setFont(new Font("微软雅黑", Font.PLAIN, 19));
                    jPasswordField3.setForeground(Color.black);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (jPasswordField3.getText().equals("")) {
                    jPasswordField3.setText("请输入价格");
                    jPasswordField3.setFont(new Font("微软雅黑", Font.PLAIN, 16));
                    jPasswordField3.setForeground(new Color(127, 127, 127));
                }
            }
        });

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jTextField.getText().equals("请输入书名") ||
                        jPasswordField.getText().equals("请输入作者名") ||
                        jPasswordField2.getText().equals("请输入出版社") ||
                        jPasswordField3.getText().equals("请输入价格")){
                    JOptionPane.showMessageDialog(null,
                            "<html><h1>您输入的信息不完整，请核对后再试！</h1><html>",
                            "搞事情？", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    try {
                        booksDao.insertDate(jTextField.getText(),
                                jPasswordField.getText(),
                                jPasswordField2.getText(),
                                jPasswordField3.getText());
                        JOptionPane.showMessageDialog(null,
                                "<html><h1>添加新书成功！</h1><html>",
                                "这是一个信息框", JOptionPane.INFORMATION_MESSAGE);
                        jTextField.setText("请输入书名");
                        jTextField.setFont(new Font("微软雅黑", Font.PLAIN, 16));
                        jTextField.setForeground(new Color(127, 127, 127));
                        jPasswordField.setText("请输入作者名");
                        jPasswordField.setFont(new Font("微软雅黑", Font.PLAIN, 16));
                        jPasswordField.setForeground(new Color(127, 127, 127));
                        jPasswordField2.setText("请输入出版社");
                        jPasswordField2.setFont(new Font("微软雅黑", Font.PLAIN, 16));
                        jPasswordField2.setForeground(new Color(127, 127, 127));
                        jPasswordField3.setText("请输入价格");
                        jPasswordField3.setFont(new Font("微软雅黑", Font.PLAIN, 16));
                        jPasswordField3.setForeground(new Color(127, 127, 127));

                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });


        Import.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileDialog fd1 = new FileDialog(jFrame, "打开", FileDialog.LOAD);
                fd1.setFile("*.txt");
                fd1.setVisible(true);

                fileName = fd1.getFile();
                filePath = fd1.getDirectory();
                jFrame.setTitle(fileName);
                try {
                    FileReader fr = new FileReader(filePath + fileName);
                    BufferedReader br = new BufferedReader(fr);
                    String sinput = "";

                    int lineNum = 0;
                    while ((sinput = br.readLine()) != null) {
                        System.out.println(sinput);
                        String[] value = sinput.split("\\|");
                        booksDao.insertDate(value[1],value[2],value[3],value[4]);
                        lineNum++;
                    }
                    JOptionPane.showMessageDialog(null,
                            "<html><h1>导入成功！</h1><hr><h3>本次成功导入&nbsp;"+lineNum
                                    +"&nbsp;本书籍，失败&nbsp;0&nbsp;本</h3><html>",
                            "这是一个信息框", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });


        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.dispose();
                Timer timer=new Timer();
                timer.schedule(new TimerTask(){
                    public void run(){
                        BooksShow bbb =new BooksShow(UserName);}},500);


            }
        });

    }


    public static void main(String[] args) {

        AddBook ee = new AddBook("test");
    }
}
