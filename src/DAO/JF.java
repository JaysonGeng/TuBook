package DAO;

import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class JF extends JFrame implements ActionListener {
    JDesktopPane jdp;
    JButton but;

    public JF() {
        super("Quistis");
        but = new JButton("添加");
        jdp = new JDesktopPane();
        this.getContentPane().add(but, BorderLayout.NORTH);
        this.getContentPane().add(jdp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        but.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        JInternalFrame ff = new JInternalFrame();//JInternalFrame==JFrame

        ((BasicInternalFrameUI)ff.getUI()).setNorthPane(null);
        ff.setBorder(BorderFactory.createEmptyBorder());
        ff.setMaximizable(true);//设子窗体有最大化按钮!!
        ff.setClosable(true);//设子窗体有关闭按钮!!
        ff.setVisible(true);
        ff.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        ff.setResizable(true);

        ff.setBounds(20,20,100,100);
        jdp.add(ff);

    }

    public static void main(String ars[]) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JF f = new JF();
        f.setSize(500, 500);
        f.validate();
        f.setVisible(true);

    }
}