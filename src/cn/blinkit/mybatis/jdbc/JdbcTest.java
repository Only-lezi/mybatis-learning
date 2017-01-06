package cn.blinkit.mybatis.jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author: Only-lezi
 * @Date: 2017-01-03 11:39
 * @Description: 通过单独的jdbc程序，总结其中的问题
 */

public class JdbcTest {
    @Test
    public void testJDBC() {
        //数据库连接
        Connection conn = null;
        //预编译的Statement。使用预编译的Statement可以将SQL语句存到数据库的缓存中，
        // 下次再发送一样的SQL语句，数据库就不再编译，提高数据库性能
        PreparedStatement ps = null;
        //结果集
        ResultSet rs = null;

        try {
            //加载数据库驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            //连接数据库
            conn = DriverManager.getConnection("jdbc:mysql:///mybatis_learning?useUnicode=true&amp;characterEncoding=UTF8", "root", "123456");

            //创建sql语句，？表示占位符
            String sql = "SELECT * FROM user WHERE username = ?";

            //获取预处理statement
            ps = conn.prepareStatement(sql);
            //设置参数，第一个参数为SQL语句中参数的序号（从1开始），第二个参数为设置的参数值
            ps.setString(1,"zhangsan");
            //向数据库发出sql执行查询，查询出结果集
            rs = ps.executeQuery();
            //遍历查询结果集
            while (rs.next()) {
                System.out.println(rs.getString("id")+ " " + rs.getString("username"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
