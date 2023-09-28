/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80028
Source Host           : localhost:3306
Source Database       : mybatisplus_db

Target Server Type    : MYSQL
Target Server Version : 80028
File Encoding         : 65001

Date: 2023-09-28 20:15:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for role_res
-- ----------------------------
DROP TABLE IF EXISTS `role_res`;
CREATE TABLE `role_res` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `role_id` bigint DEFAULT NULL,
  `res_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;

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
