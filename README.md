desc employee;
+---------------------+-------------+------+-----+---------+-------+
| Field               | Type        | Null | Key | Default | Extra |
+---------------------+-------------+------+-----+---------+-------+
| employeeId          | int(11)     | NO   | PRI | NULL    |       |
| employeeName        | varchar(30) | NO   |     | NULL    |       |
| employeeDesignation | varchar(30) | NO   |     | NULL    |       |
| employeeLocation    | varchar(20) | NO   |     | NULL    |       |
| username            | varchar(20) | NO   |     | NULL    |       |
| password            | varchar(20) | NO   |     | NULL    |       |
+---------------------+-------------+------+-----+---------+-------+
6 rows in set (0.06 sec)

mysql> desc questions;
+---------------------+---------------+------+-----+---------+----------------+
| Field               | Type          | Null | Key | Default | Extra          |
+---------------------+---------------+------+-----+---------+----------------+
| questionId          | int(11)       | NO   | PRI | NULL    | auto_increment |
| questionDescription | varchar(2000) | YES  |     | NULL    |                |
| date                | date          | YES  |     | NULL    |                |
| employeeId          | int(11)       | YES  | MUL | NULL    |                |
| categoryId          | int(11)       | YES  | MUL | NULL    |                |
+---------------------+---------------+------+-----+---------+----------------+
5 rows in set (0.00 sec)

mysql> desc answers;
+-------------------+---------------+------+-----+---------+----------------+
| Field             | Type          | Null | Key | Default | Extra          |
+-------------------+---------------+------+-----+---------+----------------+
| answerId          | int(11)       | NO   | PRI | NULL    | auto_increment |
| answerDescription | varchar(2000) | YES  |     | NULL    |                |
| date              | date          | YES  |     | NULL    |                |
| employeeId        | int(11)       | YES  | MUL | NULL    |                |
| questionId        | int(11)       | YES  | MUL | NULL    |                |
+-------------------+---------------+------+-----+---------+----------------+
5 rows in set (0.01 sec)

mysql> desc category;
+--------------+-------------+------+-----+---------+-------+
| Field        | Type        | Null | Key | Default | Extra |
+--------------+-------------+------+-----+---------+-------+
| categoryId   | int(11)     | NO   | PRI | NULL    |       |
| categoryName | varchar(20) | YES  |     | NULL    |       |
+--------------+-------------+------+-----+---------+-------+
2 rows in set (0.00 sec)
