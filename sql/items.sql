/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : commodityinfo

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-08-26 13:45:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `items`
-- ----------------------------
DROP TABLE IF EXISTS `items`;
CREATE TABLE `items` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `detail` varchar(500) DEFAULT NULL,
  `pic` text,
  `creattime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of items
-- ----------------------------
INSERT INTO `items` VALUES ('1', 'apple1', '9000', '质量不错', 'ddd.jpg', '2017-08-24 20:49:21');
INSERT INTO `items` VALUES ('2', 'apple2', '7000', 'good', 'nice.png', '2017-08-15 20:50:38');
INSERT INTO `items` VALUES ('3', 'pro1', '8000', 'nice', 'fuck.jgp', '2017-08-07 20:51:16');
