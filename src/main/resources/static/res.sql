/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80028
Source Host           : localhost:3306
Source Database       : mybatisplus_db

Target Server Type    : MYSQL
Target Server Version : 80028
File Encoding         : 65001

Date: 2023-09-28 20:15:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for res
-- ----------------------------
DROP TABLE IF EXISTS `res`;
CREATE TABLE `res` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `method` varchar(255) DEFAULT NULL,
  `pic` varchar(255) DEFAULT NULL,
  `type` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of res
-- ----------------------------
INSERT INTO `res` VALUES ('1', '添加用户', '/users', 'post', null, null);
INSERT INTO `res` VALUES ('2', '修改用户', '/users', 'put', null, null);
INSERT INTO `res` VALUES ('3', '删除用户', '/users', 'delete', null, null);
INSERT INTO `res` VALUES ('4', '查询用户', '/users', 'get', null, null);
