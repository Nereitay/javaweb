package es.kiwi.datasource.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * Druid 演示
 * 步骤：
 * 		1. 导入jar包 druid-1.0.9.jar
 * 		2. 定义配置文件：
 * 			* 是properties形式的
 * 			* 可以叫任意名称，可以放在任意目录下
 * 		3. 加载配置文件。Properties
 * 		4. 获取数据库连接池对象：通过工厂来来获取  DruidDataSourceFactory
 * 		5. 获取连接：getConnection
 */
public class DruidDemo {
    public static void main(String[] args) throws Exception {
        //3.加载配置文件
        Properties properties = new Properties();
        InputStream is = DruidDemo.class.getClassLoader().getResourceAsStream("druid.properties");
        properties.load(is);

        //4.获取连接池对象
        DataSource ds = DruidDataSourceFactory.createDataSource(properties);

        //5.获取连接
        Connection conn = ds.getConnection();
        System.out.println(conn);
    }
}
