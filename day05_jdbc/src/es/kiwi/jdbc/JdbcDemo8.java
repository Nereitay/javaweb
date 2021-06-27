package es.kiwi.jdbc;

import es.kiwi.domain.Emp;
import es.kiwi.utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *  练习：定义一个方法，查询emp表的数据将其封装为对象，然后装载集合，返回
 *  使用工具类简化操作
 */
public class JdbcDemo8 {

    public static void main(String[] args) {
        List<Emp> empList = new JdbcDemo8().findAll();
        System.out.println(empList);
        System.out.println(empList.size());
    }

    public List<Emp> findAll() {

        ResultSet rs = null;
        Statement stmt = null;
        Connection conn = null;

        Emp emp = null;
        List<Emp> empList = null;
        try {

            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from emp");
            empList = new ArrayList<>();

            while (rs.next()) {
                int id = rs.getInt("id");
                String ename = rs.getString("ename");
                int job_id = rs.getInt("job_id");
                int mgr = rs.getInt("mgr");
                Date joindate = rs.getDate("joindate");
                double salary = rs.getDouble("salary");
                double bonus = rs.getDouble("bonus");
                int dept_id = rs.getInt("dept_id");

                emp = new Emp();// 减少栈内存中的变量
                emp.setId(id);
                emp.setEname(ename);
                emp.setJob_id(job_id);
                emp.setMgr(mgr);
                emp.setJoindate(joindate);
                emp.setSalary(salary);
                emp.setBonus(bonus);
                emp.setDept_id(dept_id);

                empList.add(emp);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, stmt, conn);
        }

        return empList;
    }
}
