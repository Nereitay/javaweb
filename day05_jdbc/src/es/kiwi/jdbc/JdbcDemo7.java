package es.kiwi.jdbc;

import es.kiwi.domain.Emp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *  练习：定义一个方法，查询emp表的数据将其封装为对象，然后装载集合，返回
 */
public class JdbcDemo7 {

    public static void main(String[] args) {
        List<Emp> empList = new JdbcDemo7().findAll();
        System.out.println(empList);
        System.out.println(empList.size());
    }

    public List<Emp> findAll() {

        ResultSet rs = null;
        Statement stmt = null;
        Connection conn = null;

        Emp emp = null;
        List<Emp> empList = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///db3?characterEncoding=UTF-8&serverTimezone=UTC", "root", "root");
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from emp");

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
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            JdbcDemo2.closeResource(conn, stmt);
        }

        return empList;
    }
}
