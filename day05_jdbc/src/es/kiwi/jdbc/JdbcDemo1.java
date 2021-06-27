package es.kiwi.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * jdbc快速入门
 */
public class JdbcDemo1 {
    public static void main(String[] args) throws Exception {
        //1. 导入驱动jar包，拷贝jar包放在libs目录下，并将libs目录 add as library...

        //【DriverManager】 驱动管理对象 2个功能：注册驱动和获取获取数据库连接
        //2. 注册驱动
        /*
        Driver类中存在静态代码块, 加载进内存后自动执行，
        MYSQL5之后可以省略，因为在META-INF -> services -> java.sql.Driver中这个文件名已经设置好了，不写也会自动加载进内存
            static {
				        try {
				            java.sql.DriverManager.registerDriver(new Driver());
				        } catch (SQLException E) {
				            throw new RuntimeException("Can't register driver!");
				        }
					}
         */
        Class.forName("com.mysql.cj.jdbc.Driver");

        //【Connection】 数据库连接对象 2个功能： 获取执行sql的对象，管理事务
        //3. 获取数据库连接对象
        Connection connection = DriverManager.getConnection(
//                "jdbc:mysql://localhost:3306/db3?characterEncoding=UTF-8&serverTimezone=UTC", // 连接路径
                "jdbc:mysql:///db3?characterEncoding=UTF-8&serverTimezone=UTC", // 连接路径
                "root", // 用户名
                "root"); // 密码


        //4. 定义sql语句
        String sql = "update account set balance = 1000";
        //5. 获取执行sql对象 Statement
        Statement statement = connection.createStatement();


        //【Statement】 执行sql对象
        //6. 执行sql
        int count = statement.executeUpdate(sql); // DML DDL 返回值是影响的行数,或0 -> return nothing executeQuery -> DQL
        //7. 处理结果
        System.out.println(count);


        //8. 释放资源
        statement.close();
        connection.close();
    }
}
