package es.kiwi.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC练习 DDl语句
 */
public class JdbcDemo5 {
    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql:///db3?characterEncoding=UTF-8&serverTimezone=UTC", "root", "root");
            statement = connection.createStatement();
            int count = statement.executeUpdate("create table student(id int, name varchar(30))");
            System.out.println(count); // DDL语句返回0
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcDemo2.closeResource(connection, statement);
        }
    }
}
