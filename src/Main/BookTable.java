package Main;

import DAO.BooksDao;
import entity.Books;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

//维护表格
public class BookTable extends JPanel {
    public DefaultTableModel tableModel;   //表格模型对象
    public JTable table;
    private String fileName;
    private String filePath;

    BooksDao booksDao = new BooksDao();

    public BookTable(JFrame booksShow) {
        super();
        Font font = new Font("微软雅黑", Font.PLAIN, 15);
        setBackground(new Color(235, 242, 249));
        setLayout(null);
        String[] columnNames = {"<html><p style=\"color: #ffffff\">序</p></html>",
                "<html><p style=\"color: #ffffff\">书名</p></html>",
                "<html><p style=\"color: #ffffff\">作者名</p></html>",
                "<html><p style=\"color: #ffffff\">出版社</p></html>",
                "<html><p style=\"color: #ffffff\">价格</p></html>",
                "<html><p style=\"color: #ffffff; font-size: 10;\">Id</p></html>"};   //列名
        String[][] tableVales = {}; //数据
        tableModel = new DefaultTableModel(tableVales, columnNames);
        table = new JTable(tableModel);
        table.setFont(font);
        table.setRowHeight(30);
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// 设置table内容居中
        // tcr.setHorizontalAlignment(JLabel.CENTER);
        tcr.setHorizontalAlignment(SwingConstants.CENTER);// 这句和上句作用一样
        table.setDefaultRenderer(Object.class, tcr);

        setColumnWidth(table, 0, 40);
        setColumnWidth(table, 1, 180);
        setColumnWidth(table, 2, 180);
        setColumnWidth(table, 3, 180);
        setColumnWidth(table, 4, 60);
        setColumnWidth(table, 5, 0);


        JTableHeader header = table.getTableHeader();
        //设置表头字体
        header.setFont(new Font("微软雅黑", Font.BOLD, 20));
        //设置表头的高度
        header.setPreferredSize(new Dimension(header.getWidth(), 40));
        header.setBackground(new Color(0, 152, 194));


        JScrollPane scrollPane = new JScrollPane(table);   //支持滚动
        scrollPane.setBounds(30, 55, 645, 590);
        scrollPane.setBackground(new Color(235, 242, 249));
        this.add(scrollPane);


        scrollPane.setViewportView(table);
        scrollPane.setBackground(new Color(0, 152, 194));

        final JButton Export = new JButton("<html><p style=\"color: #ffffff\">" +
                "导&nbsp;&nbsp;出&nbsp;&nbsp;数&nbsp;&nbsp;据</p></html>");
        Export.setFont(new Font("微软雅黑", Font.BOLD, 16));
        Export.setBackground(new Color(9, 163, 220));
        Export.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                FileDialog fd = new FileDialog(booksShow, "另存为…", FileDialog.SAVE);
                fd.setFile("*.txt");
                fd.setVisible(true);
                filePath = fd.getDirectory();
                fileName = fd.getFile();
                try {
                    FileWriter fw = new FileWriter(filePath + fileName);
                    BufferedWriter bw = new BufferedWriter(fw);
                    PrintWriter pw = new PrintWriter(bw);
                    int num = table.getRowCount();
                    for (int i = 0; i <=num-1 ; i++) {
                        String value = null;
                        Books books = booksDao.getBooksById(String.valueOf(table.getValueAt(i, 5)));
                        if (books != null) {
                            value = String.valueOf(i+1)+"|"+books.getBookName() + "|"
                                    + books.getAuthor() + "|"
                                    + books.getPublishingHouse() + "|"
                                    + books.getPrice();
                            pw.write(value);
                            bw.newLine();
                        }
                    }

                    pw.flush();
                    pw.close();

                    JOptionPane.showMessageDialog(null,
                            "<html><h1>导出成功</h1><hr><h3>本次成功导入&nbsp;" + num
                                    + "&nbsp;本书籍，失败&nbsp;0&nbsp;本</h3><html>",
                            "提示", JOptionPane.INFORMATION_MESSAGE);

                } catch (Exception ex) {
                    ex.printStackTrace();

                }
            }
        });
        Export.setBounds(32, 12, 130, 30);
        this.add(Export);


        final JButton delButton = new JButton("<html><p style=\"color: #ffffff\">" +
                "删&nbsp;&nbsp;除&nbsp;&nbsp;选&nbsp;&nbsp;中&nbsp;&nbsp;项</p></html>");
        delButton.setFont(new Font("微软雅黑", Font.BOLD, 16));
        delButton.setBackground(new Color(9, 163, 220));
        delButton.addActionListener(new ActionListener() {//添加事件
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();//获得选中行的索引
                if (selectedRow != -1)  //存在选中行
                {
                    int res = JOptionPane.showConfirmDialog(null,
                            "<html><h1>是否同时从数据库中删除？</h1><html>",
                            "提示", JOptionPane.YES_NO_OPTION);
                    if (res == JOptionPane.YES_OPTION) {
                        try {
                            booksDao.deleteDateById(String.valueOf(table.getValueAt(table.getSelectedRow(), 5)));
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                    }
                    tableModel.removeRow(selectedRow);  //删除行
                }
            }
        });
        delButton.setBounds(30, 658, 200, 38);
        this.add(delButton);


        final JButton updateButton = new JButton("<html><p style=\"color: #ffffff\">" +
                "保&nbsp;&nbsp;存&nbsp;&nbsp;修&nbsp;&nbsp;改</p></html>");
        updateButton.setFont(new Font("微软雅黑", Font.BOLD, 16));
        updateButton.setBackground(new Color(9, 163, 220));
        updateButton.addActionListener(new ActionListener() {//添加事件
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();//获得选中行的索引
                try {
                    for (int i = 0; i <= table.getRowCount()-1; i++) {
                        booksDao.update(String.valueOf(table.getValueAt(i, 5)),
                                String.valueOf(table.getValueAt(i, 1)),
                                String.valueOf(table.getValueAt(i, 2)),
                                String.valueOf(table.getValueAt(i, 3)),
                                String.valueOf(table.getValueAt(i, 4)));
                    }

                } catch (Exception e1) {
                    e1.printStackTrace();
                }

                JOptionPane.showMessageDialog(null,
                        "<html><h1>保存修改成功！</h1><html>",
                        "提示", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        updateButton.setBounds(252, 658, 200, 38);
        this.add(updateButton);


        final JButton delAll = new JButton("<html><p style=\"color: #ffffff\">" +
                "清&nbsp;&nbsp;空&nbsp;&nbsp;书&nbsp;&nbsp;库</p></html>");
        delAll.setFont(new Font("微软雅黑", Font.BOLD, 16));
        delAll.setBackground(new Color(9, 163, 220));
        delAll.addActionListener(new ActionListener() {//添加事件
            public void actionPerformed(ActionEvent e) {

                int res = JOptionPane.showConfirmDialog(null,
                        "<html><h1>是否同时从数据库中删除？</h1><html>",
                        "提示", JOptionPane.YES_NO_OPTION);
                if (res == JOptionPane.YES_OPTION) {
                    try {
                        for (int i = 0; i <= tableModel.getRowCount()-1; i++)
                            booksDao.deleteDateById(String.valueOf(table.getValueAt(i, 5)));
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
                while (tableModel.getRowCount() > 0) {
                    tableModel.removeRow(tableModel.getRowCount() - 1);
                }
            }
        });
        delAll.setBounds(475, 658, 200, 38);
        this.add(delAll);
    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        BookTable test = new BookTable(new JFrame());
        test.setVisible(true);
    }

    public void setAllColumnWidth(JTable table, int width) {
        Enumeration<TableColumn> cms = table.getColumnModel().getColumns();
        while (cms.hasMoreElements()) {
            cms.nextElement().setPreferredWidth(width);
        }
    }

    public void setColumnWidth(JTable table, int column, int width) {
        table.getTableHeader().getColumnModel().getColumn(column).setPreferredWidth(width);
        table.getColumnModel().getColumn(column).setPreferredWidth(width);
    }

}


