package es.kiwi.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC练习 update语句
 */
public class JdbcDemo3 {
    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql:///db3?characterEncoding=UTF-8&serverTimezone=UTC", "root", "root");
            statement = connection.createStatement();
            int count = statement.executeUpdate("update account set balance = 1500 where id = 3");
            if (count > 0) {
                System.out.println("修改成功！");
            } else {
                System.out.println("修改失败！");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcDemo2.closeResource(connection, statement);
        }
    }


}
