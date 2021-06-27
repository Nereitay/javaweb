package es.kiwi.datasource.jdbctemplate;

import es.kiwi.utils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * JdbcTemplate入门
 */
public class JdbcTemplateDemo1 {
    public static void main(String[] args) {
        //1. 导入jar包
        //2. 创建jdbcTemplate
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        //3. 调用方法
        String sql = "update account set balance = ? where id = ?";
        int count = template.update(sql, 5000, 5);
        System.out.println(count);
    }
}
