package es.kiwi.datasource.druid;

import es.kiwi.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 使用新的工具类
 *  完成添加操作
 */
public class DruidDemo2 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            conn = JDBCUtils.getConnection();
            String sql = "insert into account values (null, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "Alice");
            pstmt.setDouble(2, 2000);
            int count = pstmt.executeUpdate();
            System.out.println(count);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(pstmt, conn);
        }
    }
}
