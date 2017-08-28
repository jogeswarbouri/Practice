create database IF NOT EXISTS logindb;

CREATE TABLE logindb.role(role_id INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL UNIQUE,role_name VARCHAR(20));

CREATE TABLE logindb.permissions(permission_id INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL UNIQUE,permission_name VARCHAR(20));

CREATE TABLE logindb.user_detail(user_id VARCHAR(10) PRIMARY KEY NOT NULL UNIQUE,user_name VARCHAR(20),user_type VARCHAR(20));

CREATE TABLE logindb.user_role(user_id VARCHAR(11) ,role_id INT(11) ,user_role_id INT(5) AUTO_INCREMENT PRIMARY KEY,FOREIGN KEY(user_id)  REFERENCES logindb.user_detail(user_id),FOREIGN KEY(role_id) REFERENCES logindb.role(role_id));

CREATE TABLE logindb.role_permission(role_permission_id INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL UNIQUE ,role_id INT(11),permission_id INT(5),FOREIGN KEY(permission_id) REFERENCES logindb.permissions(permission_id),FOREIGN KEY(role_id) REFERENCES logindb.role(role_id));

USE `logindb`;

/*Data for the table `permissions` */

insert  into logindb.permissions(`permission_id`,`permission_name`) values 

(1,'create'),

(2,'view'),

(3,'update'),

(4,'delete');

/*Data for the table `role` */

insert  into logindb.role(`role_id`,`role_name`) values 

(1,'admin'),

(2,'under-writer'),

(3,'qc'),

(4,'sales');

/*Data for the table `role_permission` */

insert  into logindb.role_permission(`role_permission_id`,`role_id`,`permission_id`) values 

(1,1,1),

(2,1,2),

(3,1,3),

(4,1,4),

(5,2,2),

(6,2,3),

(7,3,2),

(8,4,2);

/*Data for the table `user_detail` */

insert  into logindb.user_detail(`user_id`,`user_name`,`user_type`) values 

('K0102','uday','internal'),

('K0103','aditya','external'),

('K0104','gajinder','external'),

('K0105','satya','internal'),

('K0106','vijay','internal');

/*Data for the table `user_role` */

insert  into logindb.user_role(`user_id`,`role_id`,`user_role_id`) values 

('K0102',1,1),

('K0103',4,2),

('K0105',2,3),

('K0106',3,4);

select * from logindb.role;
select * from logindb.permissions;
select * from logindb.user_detail;
select * from logindb.user_role;
select * from logindb.role_permission;

