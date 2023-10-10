/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80028
Source Host           : localhost:3306
Source Database       : mybatisplus_db

Target Server Type    : MYSQL
Target Server Version : 80028
File Encoding         : 65001

Date: 2023-09-28 20:36:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for res
-- ----------------------------
DROP TABLE IF EXISTS `res`;
CREATE TABLE `res` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `url` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `method` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `pic` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `type` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of res
-- ----------------------------
INSERT INTO `res` VALUES ('1', '添加用户', '/users', 'post', null, null);
INSERT INTO `res` VALUES ('2', '修改用户', '/users', 'put', null, null);
INSERT INTO `res` VALUES ('3', '删除用户', '/users', 'delete', null, null);
INSERT INTO `res` VALUES ('4', '查询用户', '/users', 'get', null, null);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '项目经理');
INSERT INTO `role` VALUES ('2', '办公室主任');
INSERT INTO `role` VALUES ('3', '总经理');

-- ----------------------------
-- Table structure for role_res
-- ----------------------------
DROP TABLE IF EXISTS `role_res`;
CREATE TABLE `role_res` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `role_id` bigint DEFAULT NULL,
  `res_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of role_res
-- ----------------------------
INSERT INTO `role_res` VALUES ('1', '3', '1');
INSERT INTO `role_res` VALUES ('2', '3', '2');
INSERT INTO `role_res` VALUES ('3', '3', '3');
INSERT INTO `role_res` VALUES ('4', '3', '4');
INSERT INTO `role_res` VALUES ('5', '1', '1');
INSERT INTO `role_res` VALUES ('6', '1', '2');
INSERT INTO `role_res` VALUES ('7', '2', '3');
INSERT INTO `role_res` VALUES ('8', '2', '4');

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

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` bigint NOT NULL,
  `user_id` bigint DEFAULT NULL,
  `role_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '6', '2');
INSERT INTO `user_role` VALUES ('2', '6', '1');
INSERT INTO `user_role` VALUES ('3', '7', '2');
