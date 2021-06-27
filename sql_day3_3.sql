-- 事务
#概念： 如果一个包含多个步骤的业务操作，被事务管理，那么这些操作要么同时成功，要么同时失败
#操作： start transaction, rollback, commit;
 CREATE TABLE account (
  id INT PRIMARY KEY AUTO_INCREMENT,
  NAME VARCHAR (10),
  balance DOUBLE
);
INSERT INTO account (NAME, balance)
VALUES
  ('Brett', 1000),
  ('Henry', 1000);
 
SELECT * FROM account;

START TRANSACTION;
UPDATE account SET balance = balance - 500 WHERE NAME = 'Brett';
出错了...
UPDATE account SET balance = balance + 500 WHERE NAME = 'Henry';
# Commit;
ROLLBACK;

-- MySQL数据库中事务默认自动提交
/*
事务提交的两种方式：
 * 自动提交：
	* mysql就是自动提交的
	* 一条DML(增删改)语句会自动提交一次事务。
 * 手动提交：
	* Oracle 数据库默认是手动提交事务
	* 需要先开启事务，再提交
*/
SELECT @@autocommit;  -- 1 代表自动提交  0 代表手动提交
SET @@autocommit = 0;
UPDATE account SET balance = 1000;
COMMIT;

-- 事务的四大特征 ACID
# 原子性 是不可分割的最小操作单位，要么同时成功，要么同时失败 Atomicity
# 持久性 当事务提交或回滚后，数据库会持久化的保存数据 Durability
# 隔离性 多个事务之间。相互独立 Isolation
# 一致性 事务操作前后，数据总量不变 Consistency

-- 事务的隔离级别
/*概念：多个事务之间隔离的，相互独立的。
但是如果多个事务操作同一批数据，则会引发一些问题，设置不同的隔离级别就可以解决这些问题

** 相当并发操作

存在问题：
1. 脏读：一个事务，读取到另一个事务中没有提交的数据
2. 不可重复读(虚读)：在同一个事务中，两次读取到的数据不一样。
3. 幻读：一个事务操作(DML)数据表中所有记录，另一个事务添加了一条数据，则第一个事务查询不到自己的修改。

隔离级别：
 1. read uncommitted：读未提交
	* 产生的问题：脏读、不可重复读、幻读
 2. read committed：读已提交 （Oracle）
	* 产生的问题：不可重复读、幻读
 3. repeatable read：可重复读 （MySQL默认）
	* 产生的问题：幻读
 4. serializable：串行化
	* 可以解决所有的问题
*/

#SELECT @@tx_isolation;

SELECT @@transaction_isolation; -- MySQL8

SET GLOBAL TRANSACTION ISOLATION LEVEL READ COMMITTED;

#SET GLOBAL TRANSACTION ISOLATION LEVEL repeatable read;


-- DCL 管理用户，授权 DBA 数据库管理员

# 管理用户
# 查询用户
USE mysql;
SELECT * FROM USER;

# 创建用户
CREATE USER 'nerea'@'localhost' IDENTIFIED BY '123';
CREATE USER 'nereay'@'%' IDENTIFIED BY '123';

#删除用户
DROP USER 'nerea'@'localhost';

#修改密码
#set password for 'nereay'@'%' = password('123456');

#update user set password=password('123') where user='nereay' and host='%'; 

ALTER USER 'nereay'@'%' IDENTIFIED WITH mysql_native_password BY '123456'; # mysql 8 更改

# 权限管理
SHOW GRANTS FOR 'nereay'@'%';
SHOW GRANTS FOR 'root'@'localhost';

GRANT SELECT, DELETE, UPDATE ON db3.`account` TO 'nereay'@'%';
GRANT ALL ON *.* TO 'nereay'@'%';

REVOKE ALL ON *.* FROM 'nereay'@'%';