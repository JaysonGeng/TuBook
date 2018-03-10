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

import DAO.BooksDao;
import DAO.UsersDao;
import entity.Books;
import entity.Users;
import org.omg.CORBA.SetOverrideType;
import org.omg.CORBA.SetOverrideTypeHelper;


public class BooksShow {

    UsersDao usersDao = new UsersDao();
    BooksDao booksDao =new BooksDao();
    ArrayList<Users> list = new ArrayList<Users>();

    BooksShow(String name) {

        JFrame jFrame = new JFrame();
        JPanel jPanelTop = new JPanel();
        JPanel jPanelMidle = new JPanel();
        JPanel jPanelBottom =new JPanel();
        JMenuBar menus = new JMenuBar();
        menus.setBorder(null);

        JMenu File = new JMenu("");

        Font font1 =new Font("微软雅黑", Font.BOLD, 20);
        File.setFont(font1);
        menus.add(File);
        JMenuItem New = new JMenuItem("<html><h2 style=\"color: #ffffff\">用户信息(I)</h2></html>");
        JMenuItem Open = new JMenuItem("<html><h2 style=\"color: #ffffff\">注销登录(Q)</h2></html>");
        JMenuItem Save = new JMenuItem("<html><h2 style=\"color: #ffffff\">切换账户(S)</h2></html>");
        JMenuItem Exit1 = new JMenuItem("<html><h2 style=\"color: #ffffff\">退出登录(X)</h2></html>");

        File.add(New);
        File.add(Open);
        File.add(Save);
        File.add(Exit1);

        New.setBackground(new Color(0, 161,241));
        Open.setBackground(new Color(255, 187,0));
        Save.setBackground(new Color(124, 187,0));
        Exit1.setBackground(new Color(246, 83, 20));

        jPanelTop.add(menus);
        Font font=new Font("微软雅黑", Font.BOLD, 16);
        //File
        New.setFont(font);
        Open.setFont(font);
        Save.setFont(font);

        Exit1.setFont(font);
        menus.setBackground(new Color(0, 152, 194));
        menus.setBounds(0,3,10,30);

        BookTable tt =new BookTable(jFrame);
        String[] strings ={"书名","作者","出版社","价格"};
        JComboBox jComboBox = new JComboBox(strings);

        jComboBox.setOpaque(false);
        jComboBox.setBackground(Color.white);
        jComboBox.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        jComboBox.setBorder(BorderFactory.createTitledBorder("<html><p style=\"font-family: 微软雅黑; font-size: 15; color: #4CA5FF\">查找类别</p></html>"));

        JTextField jTextField = new JTextField();
        jTextField.setText("请输入查找信息");
        jTextField.setForeground(new Color(127, 127, 127));
        jTextField.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        jTextField.setBorder(BorderFactory.createTitledBorder("<html><p style=\"font-family: 微软雅黑; font-size: 15; color:#4CA5FF\">查找内容</p></html>"));
        jTextField.setBackground(new Color(235, 242, 249));

        ImageIcon icon1 = new ImageIcon("weiruan.png");
        icon1.setImage(icon1.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));

        JLabel img1 = new JLabel("", icon1, SwingConstants.CENTER);
        img1.setBounds(10, 5, 25, 25);

        JLabel title = new JLabel("图书管理系统 —— "+name);
        title.setFont(new Font("微软雅黑", Font.BOLD, 18));
        title.setForeground(Color.white);

        JButton X = new JButton("<html><h2 style=\"color: #ffffff\">x</h2></html>");
        X.setFont(new Font("微软雅黑", Font.BOLD, 5));
        X.setBackground(Color.red);
        X.setBorderPainted(false);
        X.setOpaque(false);

        JButton min = new JButton("<html><h1 style=\"color: #ffffff\">_</h1></html>");
        min.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 10));
        min.setBackground(Color.red);
        min.setBorderPainted(false);
        min.setOpaque(false);


        JButton login = new JButton("<html><p style=\"color: #ffffff\">查&nbsp;&nbsp;&nbsp;找</p></html>");
        login.setFont(new Font("微软雅黑", Font.BOLD, 16));
        login.setBackground(new Color(9, 163, 220));


        JButton addBook = new JButton("<html><p style=\"color: #ffffff\">添加新书</p></html>");
        addBook.setFont(new Font("微软雅黑", Font.BOLD, 16));
        addBook.setBackground(new Color(9, 163, 220));


        jPanelTop.setBackground(new Color(0, 152, 194));
        jPanelTop.setLayout(null);

        jPanelTop.add(img1);
        jPanelTop.add(title);
        jPanelTop.add(X);
        jPanelTop.add(min);
        min.setBounds(618, -15, 45, 50);
        X.setBounds(658, 0, 45, 40);
        title.setBounds(45, 0, 600, 35);



        jPanelMidle.setBackground(new Color(235, 242, 249));//235,242,249
        jPanelMidle.setLayout(null);
        jPanelMidle.add(jComboBox);
        jPanelMidle.add(jTextField);
        jPanelMidle.add(login);
        jPanelMidle.add(addBook);

        jComboBox.setBounds(30,15,150,65);
        jTextField.setBounds(200, 15, 235, 65);
        login.setBounds(450, 35, 80, 33);
        addBook.setBounds(555, 35, 115, 33);


        jPanelBottom.setBackground(new Color(0, 0, 0));
        jPanelBottom.setLayout(null);
        jPanelBottom.add(tt);
        tt.setBounds(0,0,700,725);


        jFrame.add(jPanelTop);
        jFrame.add(jPanelMidle);
        jFrame.add(jPanelBottom);
        jPanelTop.setBounds(0,0,700,35);
        jPanelMidle.setBounds(0,35,700,80);
        jPanelBottom.setBounds(0,115,700,725);

        jFrame.setLayout(null);
        jFrame.setSize(700, 840);
        jFrame.setLocationRelativeTo(null);
        jFrame.setUndecorated(true);
        jFrame.setTitle("图书馆管理系统 — 用户界面");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);


        New.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,
                        "<html><h1>当前账户："+name+"</h1><html>", "用户信息", JOptionPane.PLAIN_MESSAGE);
            }
        });

        Open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.dispose();
                Timer timer=new Timer();
                timer.schedule(new TimerTask(){
                    public void run(){
                        Login ll =new Login();}},500);


            }
        });

        Save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.dispose();
                Timer timer=new Timer();
                timer.schedule(new TimerTask(){
                    public void run(){
                        Login ll =new Login();}},500);
            }
        });

        Exit1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.dispose();
                Timer timer=new Timer();
                timer.schedule(new TimerTask(){
                    public void run(){
                        Login ll =new Login();}},500);
            }
        });

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

                if (jTextField.getText().equals("请输入查找信息")) {
                    jTextField.setText("");
                    jTextField.setFont(new Font("微软雅黑", Font.PLAIN, 19));
                    jTextField.setForeground(Color.black);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (jTextField.getText().equals("")) {
                    jTextField.setText("请输入查找信息");
                    jTextField.setFont(new Font("微软雅黑", Font.PLAIN, 16));
                    jTextField.setForeground(new Color(127, 127, 127));
                }
            }
        });

        addBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.dispose();
                Timer timer=new Timer();
                timer.schedule(new TimerTask(){
                    public void run(){
                        AddBook aa=new AddBook(name);}},500);

            }
        });

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(jTextField.getText().equals("请输入查找信息")){
                    ArrayList<Books> bookslist1 = booksDao.getAllUser();
                    while(tt.tableModel.getRowCount()>0){
                        tt.tableModel.removeRow(tt.tableModel.getRowCount()-1);
                    }

                    for(Books b :bookslist1){
                        String []rowValues = {String.valueOf(tt.table.getRowCount() +1),
                                b.getBookName(),b.getAuthor(),
                                b.getPublishingHouse(),b.getPrice(), String.valueOf(b.getId())};
                        tt.tableModel.addRow(rowValues);
                    }

                    if(tt.tableModel.getRowCount()==0){
                        JOptionPane.showMessageDialog(null,
                                "<html><h1>当前您的书库中没有书！</h1><html>",
                                "提示", JOptionPane.ERROR_MESSAGE);
                    }

                    else {
                        JOptionPane.showMessageDialog(null,
                                "<html><h1>在您的书库中共找到&nbsp;"+tt.tableModel.getRowCount()+"&nbsp;本书！</h1><html>",
                                "提示", JOptionPane.INFORMATION_MESSAGE);
                    }

                }
                else {
                    String str =(String) jComboBox.getSelectedItem();
                    if(str.equals("书名")){
                        while(tt.tableModel.getRowCount()>0){
                            tt.tableModel.removeRow(tt.tableModel.getRowCount()-1);
                        }
                        ArrayList<Books> bookslist1 = booksDao.getBooksByBookName(jTextField.getText());
                        for(Books b :bookslist1){
                            String []rowValues = {String.valueOf(tt.table.getRowCount() +1),
                                    b.getBookName(),b.getAuthor(),
                                    b.getPublishingHouse(),b.getPrice(), String.valueOf(b.getId())};
                            tt.tableModel.addRow(rowValues);
                        }
                        if(tt.tableModel.getRowCount()==0){
                            JOptionPane.showMessageDialog(null,
                                    "<html><h1>没有找到叫这个名字的书！</h1><html>",
                                    "提示", JOptionPane.ERROR_MESSAGE);
                        }else {
                            JOptionPane.showMessageDialog(null,
                                    "<html><h1>找到该书名的书籍共&nbsp;"+tt.tableModel.getRowCount()+"&nbsp;本！</h1><html>",
                                    "提示", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }

                    if(str.equals("作者")){
                        while(tt.tableModel.getRowCount()>0){
                            tt.tableModel.removeRow(tt.tableModel.getRowCount()-1);
                        }
                        ArrayList<Books> bookslist1 = booksDao.getBooksByAuthor(jTextField.getText());
                        for(Books b :bookslist1){
                            String []rowValues = {String.valueOf(tt.table.getRowCount() +1),
                                    b.getBookName(),b.getAuthor(),
                                    b.getPublishingHouse(),b.getPrice(), String.valueOf(b.getId())};
                            tt.tableModel.addRow(rowValues);
                        }

                        if(tt.tableModel.getRowCount()==0){
                            JOptionPane.showMessageDialog(null,
                                    "<html><h1>没有找到该作者的书籍！</h1><html>",
                                    "提示", JOptionPane.ERROR_MESSAGE);
                        }else {
                            JOptionPane.showMessageDialog(null,
                                    "<html><h1>找到该作者的书籍共&nbsp;"+tt.tableModel.getRowCount()+"&nbsp;本！</h1><html>",
                                    "提示", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }

                    if(str.equals("出版社")){
                        while(tt.tableModel.getRowCount()>0){
                            tt.tableModel.removeRow(tt.tableModel.getRowCount()-1);
                        }
                        ArrayList<Books> bookslist1 = booksDao.getBooksByPublishingHouse(jTextField.getText());
                        for(Books b :bookslist1){
                            String []rowValues = {String.valueOf(tt.table.getRowCount() +1),
                                    b.getBookName(),b.getAuthor(),
                                    b.getPublishingHouse(),b.getPrice(), String.valueOf(b.getId())};
                            tt.tableModel.addRow(rowValues);
                        }
                        if(tt.tableModel.getRowCount()==0){
                            JOptionPane.showMessageDialog(null,
                                    "<html><h1>没有找到该出版社的书籍！</h1><html>",
                                    "提示", JOptionPane.ERROR_MESSAGE);
                        }else {
                            JOptionPane.showMessageDialog(null,
                                    "<html><h1>找到该出版社的书籍共&nbsp;"+tt.tableModel.getRowCount()+"&nbsp;本！</h1><html>",
                                    "提示", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    if(str.equals("价格")) {
                        while (tt.tableModel.getRowCount() > 0) {
                            tt.tableModel.removeRow(tt.tableModel.getRowCount() - 1);
                        }
                        String[] value = jTextField.getText().split("-");
                        double from,to;
                        from=Double.valueOf(value[0]);
                        to=Double.valueOf(value[1]);
                        ArrayList<Books> bookslist =booksDao.getAllUser();
                        for(Books b :bookslist){
                            if(Double.valueOf(b.getPrice())>from && Double.valueOf(b.getPrice())<to) {
                                String[] rowValues = {String.valueOf(tt.table.getRowCount() + 1),
                                        b.getBookName(), b.getAuthor(),
                                        b.getPublishingHouse(), b.getPrice(), String.valueOf(b.getId())};
                                tt.tableModel.addRow(rowValues);
                            }
                        }
                        if(tt.tableModel.getRowCount()==0){
                            JOptionPane.showMessageDialog(null,
                                    "<html><h1>没有找到该价格内的书！</h1><html>",
                                    "提示", JOptionPane.ERROR_MESSAGE);
                        }else {
                            JOptionPane.showMessageDialog(null,
                                    "<html><h1>找到该价格内的书籍共&nbsp;"+tt.tableModel.getRowCount()+"&nbsp;本！</h1><html>",
                                    "提示", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }

                }
            }
        });
    }


    public static void main(String[] args){

        BooksShow b =new BooksShow("test");
    }
}