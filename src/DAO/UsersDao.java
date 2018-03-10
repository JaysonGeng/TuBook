package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Users;
import util.DBhelper;
public class UsersDao {

    public ArrayList<Users> getAllUser() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Users> list = new ArrayList<Users>();
        try {

            conn = DBhelper.getConnection();
            String sql = "select * from users;";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Users user = new Users();
                user.setId(rs.getInt("Id"));
                user.setUserName(rs.getString("UserName"));
                user.setPassWord(rs.getString("PassWord"));
                user.setIsRemember(rs.getInt("IsRemember"));
                user.setImage(rs.getString("Image"));
                list.add(user);
            }
            return list;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                    rs = null;
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
            if (stmt != null) {
                try {
                    stmt.close();
                    stmt = null;
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public Users getUsersByUserName(String UserName) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {

            conn = DBhelper.getConnection();
            String sql = "select * from users where UserName=?;";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, UserName);
            rs = stmt.executeQuery();
            if (rs.next()) {
                Users user = new Users();
                user.setId(rs.getInt("Id"));
                user.setUserName(rs.getString("UserName"));
                user.setPassWord(rs.getString("PassWord"));
                user.setImage(rs.getString("Image"));
                user.setIsRemember(rs.getInt("IsRemember"));
                return user;

            } else {
                return null;
            }

        } catch (Exception ex) {
            // TODO: handle exception
            ex.printStackTrace();
            return null;

        } finally {
            if (rs != null) {
                try {
                    rs.close();
                    rs = null;
                } catch (SQLException e) {
                    // TODO 自动生成的 catch 块
                    e.printStackTrace();
                }

            }
            if (stmt != null) {
                try {
                    stmt.close();
                    stmt = null;
                } catch (SQLException e) {
                    // TODO 自动生成的 catch 块
                    e.printStackTrace();
                }

            }
        }
    }

    public void insertDate(String UserName,String PassWord,String Image,int IsRemember) throws Exception {
        Connection con = null;
        con = (Connection) DBhelper.getConnection();
        PreparedStatement ps = null;
        String sql = "insert into users(UserName,PassWord,Image,IsRemember) values(?,?,?,?)";
        ps = (PreparedStatement) DBhelper.getpsta(con, sql);
        try {

            ps.setString(1,UserName);
            ps.setString(2,PassWord);
            ps.setString(3,Image);
            ps.setInt(4,IsRemember);

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public void changeIsRem(String UserName,int IsRemember) throws Exception {
        Connection con = null;
        con = (Connection) DBhelper.getConnection();
        PreparedStatement ps = null;
        String sql = "UPDATE users SET IsRemember=? WHERE UserName=?" ;
        ps = (PreparedStatement) DBhelper.getpsta(con, sql);
        try {

            ps.setInt(1,IsRemember);
            ps.setString(2,UserName);

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public void changeIsauto(String UserName,String Image) throws Exception {
        Connection con = null;
        con = (Connection) DBhelper.getConnection();
        PreparedStatement ps = null;
        String sql = "UPDATE users SET Image=? WHERE UserName=?" ;
        ps = (PreparedStatement) DBhelper.getpsta(con, sql);
        try {

            ps.setString(1,Image);
            ps.setString(2,UserName);

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}
