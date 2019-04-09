package UserOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {

    public static Connection getConn(Connection conn) {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/socialnetwork"+"?serverTimezone=GMT%2B8";
        String username = "root";
        String password = "qin7459170";
        try {
            Class.forName(driver); //classLoader,加载对应驱动
            conn = (java.sql.Connection) DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("连接数据库成功");
        return conn;
    }

}
