package es.kiwi.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC练习 insert语句
 */
public class JdbcDemo2 {
    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String sql = "insert into account values(null, 'Lucy', 3000)";

            connection = DriverManager.getConnection("jdbc:mysql:///db3?characterEncoding=UTF-8&serverTimezone=UTC", "root", "root");

            statement = connection.createStatement();

            int resultCount = statement.executeUpdate(sql);

            System.out.println(resultCount);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            //释放资源
            //避免空指针异常
            closeResource(connection, statement);
        }
    }

    static void closeResource(Connection connection, Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
