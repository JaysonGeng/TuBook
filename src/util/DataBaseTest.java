package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseTest {
	private static final String Class_Name = "org.sqlite.JDBC";
	private static final String DB_URL = "jdbc:sqlite:test.db";
	//与特定数据库的连接（会话）。
	private static Connection con = null;
	//用于执行静态 SQL 语句并返回它所生成结果的对象。 
    private static Statement stmt = null;
	
	public static void main(String[] args){
		
//		1.连接到数据库
//		Connection connection = null;
//		try{
//			con = createConnection();
//			System.out.println("Opened database successfully");
//		}catch(SQLException e){
//			System.err.println(e.getMessage());
//		}catch(Exception e){
//			e.printStackTrace();
//		}finally{
//			try{
//				if(connection!=null){
//					connection.close();
//				}
//			}catch(SQLException e){
//				//connection close failed
//				System.err.println(e);
//			}
//		}
//		2.创建表
//		createTable();
		
//		insertInfo();
//		getAllInfo();
		
//		updateInfo();
		insertOneInfo(5, "wqe", 15, "Cato");
//		getAllInfo();
	
		
	}
	
    // 创建Sqlite数据库连接
    public static Connection createConnection() throws SQLException, ClassNotFoundException {
    	//类加载器尝试加载和链接Driver“org.gjt.mm.mysql”包中的类。如果成功，则调用静态初始化程序。
    	Class.forName(Class_Name);
        //建立一个数据库名testSQLite.db的连接，如果不存在就目录下创建之
        return DriverManager.getConnection(DB_URL);
    }
    
    public static void createTable(){
    	try{
    		con =  createConnection();
    		stmt = con.createStatement();
    		
    		String sql = "create table school "+
    					 "(id int primary key not null,"+
    					 "name text not null,"+
    					 "age int not null," +
    					 "address char(50))";
    		stmt.executeUpdate(sql);
    		stmt.close();
    		con.close();
    	}catch (Exception e){
    		System.err.println(e.getClass().getName()+ ":" +e.getMessage());
    		System.exit(0);
    	}
    	System.out.println("Table created successfully");
    }
    
    
    public static void insertInfo(){
        try {
          con = createConnection();
          con.setAutoCommit(false);
          System.out.println("Opened database successfully");

          stmt = con.createStatement();
          String sql = "insert into school (id,name,age,address) " +
                       "VALUES (1, 'Paul', 32, 'California');"; 
          stmt.executeUpdate(sql);

          sql = "insert into school (id,name,age,address) " +
                "VALUES (2, 'Allen', 25, 'Texas');"; 
          stmt.executeUpdate(sql);

          sql = "insert into school (id,name,age,address) " +
                "VALUES (3, 'Teddy', 23, 'Norway');"; 
          stmt.executeUpdate(sql);
          
          sql = "insert into school (id,name,age,address) " +
                "VALUES (4, 'Mark', 25, 'Rich-Mond ');"; 
          stmt.executeUpdate(sql);

          stmt.close();
          con.commit();
          con.close();
        } catch ( Exception e ) {
          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
          System.exit(0);
        }
        System.out.println("Records created successfully");
    }
    
    public static void insertOneInfo(int id,String name,int age,String address){
    	try {
            con = createConnection();
            con.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = con.createStatement();
            String sql = "insert into school (id,name,age,address) " +
                         "VALUES ("+id+", \'"+name+"\', "+age+", \'"+address+"\');"; 
            stmt.executeUpdate(sql);
            stmt.close();
            con.commit();
            con.close();
          } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
          }
          System.out.println("Records created successfully");
    }
    
    public static void getAllInfo(){
        try {
          //连接数据库
          con = createConnection();
          con.setAutoCommit(false);
          System.out.println("Opened database successfully");
          
          stmt = con.createStatement();
          ResultSet rs = stmt.executeQuery( "select * from school;" );
          while ( rs.next() ) {
             int id = rs.getInt("id");
             String  name = rs.getString("name");
             int age  = rs.getInt("age");
             String  address = rs.getString("address");
             System.out.println( "id = " + id );
             System.out.println( "name = " + name );
             System.out.println( "age = " + age );
             System.out.println( "address = " + address );
             System.out.println("---------------");
          }
          rs.close();
          stmt.close();
          con.close();
        } catch ( Exception e ) {
          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
          System.exit(0);
        }
        System.out.println("Operation done successfully");
    }
    
    public static void updateInfo(){
    	try {
    	      Class.forName("org.sqlite.JDBC");
    	      con = DriverManager.getConnection("jdbc:sqlite:test.db");
    	      con.setAutoCommit(false);
    	      System.out.println("Opened database successfully");

    	      stmt = con.createStatement();
    	      String sql = "update school set address =\"China\" where id = 4;";
    	      stmt.executeUpdate(sql);
    	      con.commit();
    	      
    	      stmt.close();
    	      con.close();
    	    } catch ( Exception e ) {
    	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
    	      System.exit(0);
    	    }
    	    System.out.println("Operation done successfully");
    }
}
    

