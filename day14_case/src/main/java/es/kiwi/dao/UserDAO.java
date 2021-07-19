package es.kiwi.dao;

import es.kiwi.domain.User;
import es.kiwi.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * 操作数据库中User表的类
 */
public class UserDAO {

    //声明JDBCTemplate对象共用
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 登录方法
     *
     * @param loginUser 只有用户名和密码
     * @return user包含用户全部数据
     */
    public User login(User loginUser) {
        try {
            // 1.编写sql
            String sql = "select * from user where username = ? and password = ?";
            //2. 调用query方法
            User user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(), loginUser.getPassword());

            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();// 一般在此处记录日志
            return null;
        }
    }
}
