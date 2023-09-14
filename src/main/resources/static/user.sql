/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80028
Source Host           : localhost:3306
Source Database       : mybatisplus_db

Target Server Type    : MYSQL
Target Server Version : 80028
File Encoding         : 65001

Date: 2023-09-14 19:02:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `age` int NOT NULL,
  `tel` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'tom', '123456', '12', '12345678910');
INSERT INTO `user` VALUES ('2', 'jack', '123456', '8', '12345678910');
INSERT INTO `user` VALUES ('3', 'jerry', '123456', '15', '12345678910');
INSERT INTO `user` VALUES ('4', 'tom', '123456', '9', '12345678910');
INSERT INTO `user` VALUES ('5', 'snake', '123456', '28', '12345678910');
INSERT INTO `user` VALUES ('6', '张益达', '123456', '22', '12345678910');
INSERT INTO `user` VALUES ('7', '张⼤炮', '123456', '16', '12345678910');

--
-- create database if not exists mybatisplus_db character set utf8;
-- use mybatisplus_db;
-- CREATE TABLE user (
--  id bigint(20) primary key auto_increment,
--  name varchar(32) not null,
-- password varchar(32) not null,
--  age int(3) not null ,
--  tel varchar(32) not null
-- );
-- insert into user values(null,'tom','123456',12,'12345678910');
-- insert into user values(null,'jack','123456',8,'12345678910');
-- insert into user values(null,'jerry','123456',15,'12345678910');
-- insert into user values(null,'tom','123456',9,'12345678910');
-- insert into user values(null,'snake','123456',28,'12345678910');
-- insert into user values(null,'张益达','123456',22,'12345678910');
-- insert into user values(null,'张⼤炮','123456',16,'12345678910');