CREATE DATABASE db2;
USE db2;
# 创建部门表
 CREATE TABLE dept (
  id INT PRIMARY KEY AUTO_INCREMENT,
  NAME VARCHAR (20)
);

INSERT INTO dept (NAME)
VALUES
  ('开发部'),
  ('市场部'),
  ('财务部');

# 创建员工表
 CREATE TABLE emp (
  id INT PRIMARY KEY AUTO_INCREMENT,
  NAME VARCHAR (10),
  gender CHAR (1),
  -- 性别
   salary DOUBLE,
  -- 工资
   join_date DATE,
  -- 入职日期
   dept_id INT,
  FOREIGN KEY (dept_id) REFERENCES dept (id) -- 外键，关联部门表(部门表的主键)
);

INSERT INTO emp(NAME,gender,salary,join_date,dept_id) VALUES('孙悟空','男',7200,'2013-02-24',1);
INSERT INTO emp(NAME,gender,salary,join_date,dept_id) VALUES('猪八戒','男',3600,'2010-12-02',2);
INSERT INTO emp(NAME,gender,salary,join_date,dept_id) VALUES('唐僧','男',9000,'2008-08-08',2);
INSERT INTO emp(NAME,gender,salary,join_date,dept_id) VALUES('白骨精','女',5000,'2015-10-07',3);
INSERT INTO emp(NAME,gender,salary,join_date,dept_id) VALUES('蜘蛛精','女',4500,'2011-03-14',1);

SELECT COUNT(*) FROM emp, dept; # 笛卡尔积 5 * 3 = 15
SELECT * FROM emp, dept;
SELECT * FROM emp;

-- 消除无用数据（笛卡尔积）
# 内连接 隐式where   显式join 从哪些表中，哪些条件，哪些字段查询
# 外连接 左外 右外
# 子查询

-- 查询所有员工信息和对应的部门信息
SELECT * FROM emp, dept WHERE emp.`dept_id` = dept.`id`;

-- 查询员工表的名称，性别。部门表的名称
SELECT emp.name, emp.gender, dept.name FROM emp, dept WHERE emp.`dept_id` = dept.`id`;
SELECT
  t1.name, -- 员工表的姓名
  t1.gender, -- 员工表的性别
  t2.name -- 部门表的名称
FROM
  emp t1,
  dept t2
WHERE t1.`dept_id` = t2.`id`;

#显式
SELECT
  *
FROM
  emp t1
  JOIN dept t2
    ON t1.`dept_id` = t2.`id`;

#左外连接 查询的是左表所有数据以及其交集部分
-- 查询所有员工信息，如果员工有部门，则查询部门名称，没有部门，则不显示部门名称
SELECT
  e.*,
  d.name
FROM
  emp e
  LEFT JOIN dept d
    ON e.`dept_id` = d.`id`;

SELECT
  e.*,
  d.name
FROM
  emp e
  RIGHT JOIN dept d
    ON e.`dept_id` = d.`id`;

SELECT
  e.*,
  d.name
FROM
  dept d
  RIGHT JOIN emp e
    ON e.`dept_id` = d.`id`;
    
#子查询 查询中嵌套查询
-- 查询工资最高的员工信息
-- 1 查询最高的工资是多少
SELECT MAX(salary) FROM emp;
-- 2 查询员工信息，并且工资等于最高工资
SELECT * FROM emp WHERE emp.`salary`=9000;
-- 一条sql就完成这个操作。子查询
SELECT * FROM emp WHERE emp.`salary` = (SELECT MAX(salary) FROM emp);

-- 子查询的不同情况
#1.子查询的结果是单行单列的 子查询可以作为条件，使用运算符去判断。 运算符： > >= < <= =
# 查询员工工资小于平均工资的人
SELECT * FROM emp WHERE emp.`salary` < (SELECT AVG(salary) FROM emp);

#2. 子查询的结果是多行单列的 子查询可以作为条件，使用运算符in来判断
# 查询'财务部'和'市场部'所有的员工信息
SELECT
  *
FROM
  emp
WHERE emp.`dept_id` IN
  (SELECT
    id
  FROM
    dept
  WHERE NAME IN ('财务部', '市场部'));

#3. 子查询的结果是多行多列的： 子查询可以作为一张虚拟表参与查询
# 查询员工入职日期是2011-11-11日之后的员工信息和部门信息
# 子查询
SELECT
  *
FROM
  dept d,
  (SELECT
    *
  FROM
    emp
  WHERE emp.`join_date` > '2011-11-11') e
WHERE e.`dept_id` = d.`id`;

SELECT
  *
FROM
  dept d
  JOIN
    (SELECT
      *
    FROM
      emp
    WHERE emp.`join_date` > '2011-11-11') e
    ON d.`id` = e.dept_id;

#普通内连接
SELECT
  *
FROM
  emp t1,
  dept t2
WHERE t1.`dept_id` = t2.`id`
  AND t1.`join_date` > '2011-11-11';



