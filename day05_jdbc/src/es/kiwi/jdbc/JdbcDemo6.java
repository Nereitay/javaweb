package es.kiwi.jdbc;

import java.sql.*;

/**
 * JDBC ResultSet
 */
public class JdbcDemo6 {
    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql:///db3?characterEncoding=UTF-8&serverTimezone=UTC", "root", "root");
            statement = connection.createStatement();

            //ResultSet 结果集对象，封装查询结果 boolean next(): 游标向下移动一行
            rs = statement.executeQuery("select * from account");
            while (rs.next()) { //让游标向下移动一行
                int id = rs.getInt(1); // 参数：列数
                String name = rs.getString("name");
                double balance = rs.getDouble(3);

                System.out.println(id + "---" + name + "---" + balance);

            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            JdbcDemo2.closeResource(connection, statement);
        }
    }
}
