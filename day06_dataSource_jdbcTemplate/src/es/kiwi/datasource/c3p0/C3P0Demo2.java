package es.kiwi.datasource.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * C3P0演示 最大连接数量
 */
public class C3P0Demo2 {
    public static void main(String[] args) throws SQLException {
        //获取DataSource 使用默认配置
        DataSource ds = new ComboPooledDataSource();

        //获取DataSource 使用默认配置 使用指定名称配置
//        DataSource ds = new ComboPooledDataSource("otherc3p0");

        for (int i = 0; i < 11; i++) {
            Connection conn = ds.getConnection();
            System.out.println(i + ":" + conn);
            if (i==5) {
                conn.close();//归还连接到连接池
            }
        }

    }
}
