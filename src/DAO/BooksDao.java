package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Books;
import entity.Users;
import util.DBhelper;
public class BooksDao {

    public ArrayList<Books> getAllUser() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Books> list = new ArrayList<Books>();
        try {

            conn = DBhelper.getConnection();
            String sql = "select * from books;";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Books book = new Books();
                book.setId(rs.getInt("Id"));
                book.setBookName(rs.getString("BookName"));
                book.setAuthor(rs.getString("Author"));
                book.setPublishingHouse(rs.getString("PublishingHouse"));
                book.setPrice(rs.getString("Price"));
                list.add(book);
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

    public ArrayList<Books> getBooksByAuthor(String Author) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Books> list = new ArrayList<Books>();
        try {

            conn = DBhelper.getConnection();
            String sql = "select * from books where Author=?;";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, Author);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Books book = new Books();
                book.setId(rs.getInt("Id"));
                book.setBookName(rs.getString("BookName"));
                book.setAuthor(rs.getString("Author"));
                book.setPublishingHouse(rs.getString("PublishingHouse"));
                book.setPrice(rs.getString("Price"));
                list.add(book);

            }
            return list;

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

    public ArrayList<Books> getBooksByPublishingHouse(String PublishingHouse) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Books> list = new ArrayList<Books>();
        try {

            conn = DBhelper.getConnection();
            String sql = "select * from books where PublishingHouse=?;";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, PublishingHouse);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Books book = new Books();
                book.setId(rs.getInt("Id"));
                book.setBookName(rs.getString("BookName"));
                book.setAuthor(rs.getString("Author"));
                book.setPublishingHouse(rs.getString("PublishingHouse"));
                book.setPrice(rs.getString("Price"));
                list.add(book);

            }
            return list;

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

    public ArrayList<Books> getBooksByBookName(String BookName) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Books> list = new ArrayList<Books>();
        try {

            conn = DBhelper.getConnection();
            String sql = "select * from books where BookName=?;";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, BookName);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Books book = new Books();
                book.setId(rs.getInt("Id"));
                book.setBookName(rs.getString("BookName"));
                book.setAuthor(rs.getString("Author"));
                book.setPublishingHouse(rs.getString("PublishingHouse"));
                book.setPrice(rs.getString("Price"));
                list.add(book);

            }
            return list;

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

    public void insertDate(String BookName,String Author,String PublishingHouse,String Price) throws Exception {
        Connection con = null;
        con = (Connection) DBhelper.getConnection();
        PreparedStatement ps = null;
        String sql = "insert into books(BookName,Author,PublishingHouse,Price) values(?,?,?,?)";
        ps = (PreparedStatement) DBhelper.getpsta(con, sql);
        try {

            ps.setString(1,BookName);
            ps.setString(2,Author);
            ps.setString(3,PublishingHouse);
            ps.setString(4,Price);

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public void deleteDateById(String Id) throws Exception {
        Connection con = null;
        con = (Connection) DBhelper.getConnection();
        PreparedStatement ps = null;
        String sql = "DELETE FROM books WHERE Id=?" ;
        ps = (PreparedStatement) DBhelper.getpsta(con, sql);
        try {
            ps.setString(1,Id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public void update(String Id,String BookName, String Author,String PublishingHouse,String Price) throws Exception {
        Connection con = null;
        con = (Connection) DBhelper.getConnection();
        PreparedStatement ps = null;
        String sql = "UPDATE books SET Author=? WHERE Id=?" ;
        ps = (PreparedStatement) DBhelper.getpsta(con, sql);
        try {

            ps.setString(1,Author);
            ps.setString(2,Id);

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {

            e.printStackTrace();
        }

        sql =null;
        sql = "UPDATE books SET PublishingHouse=? WHERE Id=?" ;
        ps = (PreparedStatement) DBhelper.getpsta(con, sql);
        try {

            ps.setString(1,PublishingHouse);
            ps.setString(2,Id);

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {

            e.printStackTrace();
        }

        sql =null;
        sql = "UPDATE books SET Price=? WHERE Id=?" ;
        ps = (PreparedStatement) DBhelper.getpsta(con, sql);
        try {

            ps.setString(1,Price);
            ps.setString(2,Id);

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {

            e.printStackTrace();
        }

        sql =null;
        sql = "UPDATE books SET BookName=? WHERE Id=?" ;
        ps = (PreparedStatement) DBhelper.getpsta(con, sql);
        try {

            ps.setString(1,BookName);
            ps.setString(2,Id);

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public Books getBooksById(String Id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {

            conn = DBhelper.getConnection();
            String sql = "select * from books where Id=?;";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, Id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                Books book = new Books();
                book.setId(rs.getInt("Id"));
                book.setBookName(rs.getString("BookName"));
                book.setAuthor(rs.getString("Author"));
                book.setPublishingHouse(rs.getString("PublishingHouse"));
                book.setPrice(rs.getString("Price"));
                return book;
            }
            else
                return null;

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

}
