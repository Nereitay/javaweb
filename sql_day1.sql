USE db1;

DESC stu;

SHOW CREATE TABLE stu;

SHOW VARIABLES LIKE 'explicit_defaults_for_timestamp';

SET @@session.explicit_defaults_for_timestamp =
ON;

SET @@global.explicit_defaults_for_timestamp =
ON;

SHOW GLOBAL VARIABLES LIKE 'explicit_defaults_for_timestamp';

SELECT
  DATABASE ();

ALTER TABLE stu
  MODIFY insert_time TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP;

ALTER TABLE stu
  DROP insert_time;

ALTER TABLE stu
  ADD insert_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP;

-- DML
# 添加
 INSERT INTO stu (id, NAME, age)
VALUES
  (3, '张无忌', 18);

SELECT
  *
FROM
  stu;

INSERT INTO stu
VALUES
  (
    2,
    '赵敏',
    22,
    99.9,
    '1893-11-11',
    NULL
  );

/*
如果不加条件，则删除表中所有记录
不推荐使用。有多少条记录就会执行多少次删除操作
*/
DELETE
FROM
  stu
WHERE id = 1;

-- 推荐使用，效率更高 先删除表，然后再创建一张一样的表
 TRUNCATE TABLE stu;

UPDATE
  stu
SET
  age = 117
WHERE id = 3;

UPDATE
  stu
SET
  age = 18,
  score = 100
WHERE id = 3;

CREATE TABLE student (
  id INT,
  NAME VARCHAR (30),
  age INT,
  sex VARCHAR (5),
  address VARCHAR (100),
  math INT,
  english INT
);

INSERT INTO student (
  id,
  NAME,
  age,
  sex,
  address,
  math,
  english
)
VALUES
  (1, '马云', 55, '男', '杭州', 66, 78),
  (
    2,
    '马化腾',
    45,
    '女',
    '深圳',
    98,
    87
  ),
  (
    3,
    '马景涛',
    55,
    '男',
    '香港',
    56,
    77
  ),
  (4, '柳岩', 20, '女', '湖南', 76, 65),
  (
    5,
    '柳青',
    20,
    '男',
    '湖南',
    86,
    NULL
  ),
  (
    6,
    '刘德华',
    57,
    '男',
    '香港',
    99,
    99
  ),
  (7, '马德', 22, '女', '香港', 99, 99),
  (
    8,
    '德玛西亚',
    18,
    '男',
    '南京',
    56,
    65
  );

-- DQL
/*select
  *
from
  student
where
group by
having
order by
limit;*/

SELECT
  *
FROM
  student;

SELECT DISTINCT
  address
FROM
  student;

SELECT DISTINCT
  NAME,
  address
FROM
  student;

SELECT
  NAME,
  math,
  english,
  math + english #一般可以使用四则运算计算一些列的值。（一般只会进行数值型的计算）
FROM
  student;

-- 如果有null参与运算，结果都为null
 SELECT
  NAME,
  math,
  english,
  math + IFNULL (english, 0)
FROM
  student;

--  起别名： as：as也可以省略
SELECT
  NAME,
  math 数学,
  english 英语,
  math + IFNULL (english, 0) AS 总分
FROM
  student;

-- 条件查询

-- 查询年龄大于20岁 > 、< 、<= 、>= 、= 、<>
SELECT * FROM student WHERE age = 20;
SELECT * FROM student WHERE age <> 20;
SELECT * FROM student WHERE age != 20;

SELECT* FROM student WHERE age >= 20 AND age <= 30;
SELECT * FROM student WHERE age BETWEEN 20 AND 30;

SELECT * FROM student WHERE age = 22 OR age = 18 OR age = 25;
SELECT * FROM student WHERE age IN(22, 18, 25);

# null值不能使用 = （!=） 判断
SELECT * FROM student WHERE english IS NULL;
SELECT * FROM student WHERE english IS NOT NULL;

SELECT * FROM student WHERE sex != '女';

-- 模糊查询 like
SELECT * FROM student WHERE NAME LIKE '马_';
SELECT * FROM student WHERE NAME LIKE '_化%';
SELECT * FROM student WHERE NAME LIKE '___'; #查询姓名是3个字的人
SELECT * FROM student WHERE NAME LIKE '%马%';

-- 排序
SELECT * FROM student ORDER BY math;
# 如果有多个排序条件，则当前边的条件值一样时，才会判断第二条件
SELECT * FROM student ORDER BY math ASC, english DESC;

-- 聚合函数 注意：聚合函数的计算，排除null值 count, avg, sum, max, min
SELECT COUNT(english) FROM student;
SELECT COUNT(*) FROM student;
SELECT COUNT(id) FROM student;

SELECT COUNT(IFNULL(english, 0)) FROM student;

SELECT MAX(math) FROM student;

SELECT SUM(english) FROM student;

SELECT AVG(math) FROM student;

-- 分组查询 select 字段 要么是分组字段，要么聚合函数
SELECT AVG(math), sex, COUNT(id) FROM student GROUP BY sex;
SELECT AVG(math), sex, COUNT(id) FROM student WHERE math > 70 GROUP BY sex;
SELECT AVG(math), sex, COUNT(id) FROM student WHERE math > 70 GROUP BY sex HAVING sex = '女';
# 按照性别分组。分别查询男、女同学的平均分,人数 要求：分数低于70分的人，不参与分组,分组之后。人数要大于2个人
SELECT AVG(math), sex, COUNT(id) 人数 FROM student WHERE math > 70 GROUP BY sex HAVING 人数 > 2;

-- 分页查询 limit 开始的索引,每页查询的条数 公式：开始的索引 = （当前的页码 - 1） * 每页显示的条数
SELECT * FROM student LIMIT 3,3; # limit 是一个MySQL"方言"


-- 约束 对表中的数据进行限定，保证数据的正确性、有效性和完整性
-- 非空约束
DROP TABLE IF EXISTS stu;
# 创建表时添加约束
CREATE TABLE stu (
	id INT,
	NAME VARCHAR(20) NOT NULL #非空
);
# 删除name的非空约束
ALTER TABLE stu MODIFY NAME VARCHAR(20);

DESC stu;
# 创建表完后，添加非空约束
ALTER TABLE stu MODIFY NAME VARCHAR(20) NOT NULL;

-- 唯一约束
CREATE TABLE stu (
	id INT,
	phone_number VARCHAR(20) UNIQUE #唯一
);

SELECT * FROM stu;
#  删除唯一约束
ALTER TABLE stu DROP INDEX phone_number;
# 在表创建完后，添加唯一约束
 ALTER TABLE stu
  MODIFY phone_number VARCHAR (20) UNIQUE;

-- 主键约束 非空且唯一 一张表只能有一个字段为主键 主键就是表中记录的唯一标识
 CREATE TABLE stu (
  id INT PRIMARY KEY AUTO_INCREMENT,
  #主键 自动增长
   NAME VARCHAR (20)
);

ALTER TABLE stu DROP PRIMARY KEY;
#  删除自动增长
ALTER TABLE stu MODIFY id INT;

ALTER TABLE stu MODIFY id INT AUTO_INCREMENT;

INSERT INTO stu VALUES(NULL, 'ccc');

-- 外键约束
 CREATE TABLE emp (
  id INT PRIMARY KEY AUTO_INCREMENT,
  NAME VARCHAR (30),
  age INT,
  dep_name VARCHAR (30),
  dep_location VARCHAR (30)
);

INSERT INTO emp (NAME, age, dep_name, dep_location)
VALUES
  ('张三', 20, '研发部', '广州'),
  ('李四', 21, '研发部', '广州'),
  ('王五', 20, '研发部', '广州'),
  ('老王', 20, '销售部', '深圳'),
  ('大王', 22, '销售部', '深圳'),
  ('小王', 18, '销售部', '深圳');
  
DESC emp;
SELECT * FROM emp;

# 数据冗余
# 表拆分
-- 解决方案：分成 2 张表
-- 创建部门表(id,dep_name,dep_location)
-- 一方，主表
CREATE TABLE department(
id INT PRIMARY KEY AUTO_INCREMENT,
dep_name VARCHAR(20),
dep_location VARCHAR(20)
);
-- 创建员工表(id,name,age,dep_id)
-- 多方，从表
CREATE TABLE employee(
id INT PRIMARY KEY AUTO_INCREMENT,
NAME VARCHAR(20),
age INT,
dep_id INT, -- 外键对应主表的主键
CONSTRAINT emp_dept_fk FOREIGN KEY (dep_id) REFERENCES department(id)
);
-- 添加 2 个部门
INSERT INTO department VALUES(NULL, '研发部','广州'),(NULL, '销售部', '深圳');
SELECT * FROM department;
-- 添加员工,dep_id 表示员工所在的部门
INSERT INTO employee (NAME, age, dep_id) VALUES ('张三', 20, 1);
INSERT INTO employee (NAME, age, dep_id) VALUES ('李四', 21, 1);
INSERT INTO employee (NAME, age, dep_id) VALUES ('王五', 20, 1);
INSERT INTO employee (NAME, age, dep_id) VALUES ('老王', 20, 2);
INSERT INTO employee (NAME, age, dep_id) VALUES ('大王', 22, 2);
INSERT INTO employee (NAME, age, dep_id) VALUES ('小王', 18, 2);
SELECT * FROM employee;

DROP TABLE emp;
DROP TABLE department;
DROP TABLE employee;

# 删除外键
 ALTER TABLE employee
  DROP FOREIGN KEY emp_dept_fk;
# 添加外键 设置级联更新和删除
 ALTER TABLE employee
  ADD CONSTRAINT emp_dept_fk FOREIGN KEY (dep_id) REFERENCES department (id) ON UPDATE CASCADE ON DELETE CASCADE;

UPDATE employee SET dep_id = NULL WHERE dep_id = 1;
UPDATE employee SET dep_id = 5 WHERE dep_id IS NULL;

