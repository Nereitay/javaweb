package es.kiwi.datasource.jdbctemplate;

import es.kiwi.domain.Emp;
import es.kiwi.utils.JDBCUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * JdbcTemplate DML DQL
 * 需求：
 * 			1. 修改1号数据的 salary 为 10000
 * 			2. 添加一条记录
 * 			3. 删除刚才添加的记录
 * 			4. 查询id为1的记录，将其封装为Map集合
 * 			5. 查询所有记录，将其封装为List
 * 			6. 查询所有记录，将其封装为Emp对象的List集合
 * 			7. 查询总记录数
 */
public class JdbcTemplateDemo2 {

    //Junit单元测试

    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());


    /*
        【update()】:执行DML语句。增、删、改语句
    */
    // 1. 修改1号数据的 salary 为 10000
    @Test
    public void test1() {
        String sql = "update emp set salary = ? where id = ?";
        int count = jdbcTemplate.update(sql, 10000, 1001);
        System.out.println(count);
    }

    //2. 添加一条记录
    @Test
    public void test2() {
        String sql = "insert into emp(id, ename, dept_id) values(?, ?, ?)";
        int count = jdbcTemplate.update(sql, 1015, "郭靖", 10);
        System.out.println(count);

    }

    //3. 删除刚才添加的记录
    @Test
    public void test3() {
        String sql = "delete from emp where id = ?";
        int count = jdbcTemplate.update(sql, 1015);
        System.out.println(count);

    }

    //4. 查询id为1的记录，将其封装为Map集合
    @Test
    public void test4() {
        String sql = "select * from emp where id = ?";
        // 注意：这个方法查询的结果集长度只能是1
        /*
        【queryForMap()】:查询结果将结果集封装为map集合，将列名作为key，将值作为value 将这条记录封装为一个map集合
         */
        Map<String, Object> map = jdbcTemplate.queryForMap(sql, 1001);
        System.out.println(map);

    }

    //5. 查询所有记录，将其封装为List
    @Test
    public void test5() {
        String sql = "select * from emp";
        /*
        【queryForList()】:查询结果将结果集封装为list集合
			* 注意：将每一条记录封装为一个Map集合，再将Map集合装载到List集合中
         */
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        System.out.println(list);

    }

    //6. 查询所有记录，将其封装为List
    @Test
    public void test6() {
        String sql = "select * from emp";

        /*List<Emp> list = jdbcTemplate.query(sql, new RowMapper<Emp>() {

            @Override
            public Emp mapRow(ResultSet resultSet, int i) throws SQLException {
                Emp emp = new Emp();
                int id = resultSet.getInt("id");
                String ename = resultSet.getString("ename");
                int job_id = resultSet.getInt("job_id");
                int mgr = resultSet.getInt("mgr");
                Date joindate = resultSet.getDate("joindate");
                double salary = resultSet.getDouble("salary");
                double bonus = resultSet.getDouble("bonus");
                int dept_id = resultSet.getInt("dept_id");

                emp.setId(id);
                emp.setEname(ename);
                emp.setJob_id(job_id);
                emp.setMgr(mgr);
                emp.setJoindate(joindate);
                emp.setSalary(salary);
                emp.setBonus(bonus);
                emp.setDept_id(dept_id);
                return emp;
            }
        });*/

        // org.springframework.beans.TypeMismatchException double -> Double, 基本数据类型不能为Null
        /*
        【query()】:查询结果，将结果封装为JavaBean对象
			* query的参数：【RowMapper】
				* 一般我们使用【BeanPropertyRowMapper】实现类。可以完成数据到JavaBean的自动封装
				* new BeanPropertyRowMapper<类型>(类型.class)
         */
        List<Emp> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Emp>(Emp.class));
        System.out.println(list);

    }

    // 7. 查询总记录数
    @Test
    public void test7() {
        String sql = "select count(id) from emp";
        //【queryForObject()】一般用于执行聚合函数
        Long total = jdbcTemplate.queryForObject(sql, Long.class);
        System.out.println(total);
    }


 }
