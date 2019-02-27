package jdbc;

/**
 * @Author: 低调的小码农
 * @Date: 2019/2/26 11:12 PM
 * @Version 1.0
 */
import java.sql.*;

public class TestJDBC {
    public static void main(String[] args) throws Exception{
        //1.首先加入Oracle包
        //2.new 数据库实例，自动注册
        Class.forName("oracle.jdbc.driver.OracleDriver");
        //3.连接Oracle
        Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@172.16.3.142:1521:kaifa","ydjy","ydjy");
        //4.创建一个Statement
        Statement stmt = conn.createStatement();
        String sql = "select count(*) from aa26";
        //5.执行查询
        ResultSet rs = stmt.executeQuery(sql);
        //6.获取结果
        while (rs.next()) {
            System.out.print(rs.getString(1));
        }
       /* 7.关闭JDBC对象
        操作完成以后要把所有使用的JDBC对象全都关闭，以释放JDBC资源，关闭顺序和声
        明顺序相反：
        1、关闭记录集
        2、关闭声明
        3、关闭连接对象*/
        if(rs != null){   // 关闭记录集
            try{
                rs.close() ;
            }catch(SQLException e){
                e.printStackTrace() ;
            }
        }
        if(stmt != null){   // 关闭声明
            try{
                stmt.close() ;
            }catch(SQLException e){
                e.printStackTrace() ;
            }
        }
        if(conn != null){  // 关闭连接对象
            try{
                conn.close() ;
            }catch(SQLException e){
                e.printStackTrace() ;
            }
        }
    }
}
