/*
Navicat MySQL Data Transfer

Source Server         : Tom
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : student_manage

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2020-07-07 19:24:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for change_code_info
-- ----------------------------
DROP TABLE IF EXISTS `change_code_info`;
CREATE TABLE `change_code_info` (
  `code` varchar(8) NOT NULL,
  `description` varchar(128) NOT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='学籍变动代码表';

-- ----------------------------
-- Records of change_code_info
-- ----------------------------
INSERT INTO `change_code_info` VALUES ('0', '转系');
INSERT INTO `change_code_info` VALUES ('1', '休学');
INSERT INTO `change_code_info` VALUES ('2', '复学');
INSERT INTO `change_code_info` VALUES ('3', '退学');
INSERT INTO `change_code_info` VALUES ('4', '毕业');

-- ----------------------------
-- Table structure for change_info
-- ----------------------------
DROP TABLE IF EXISTS `change_info`;
CREATE TABLE `change_info` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `student_id` varchar(32) NOT NULL,
  `change_code` varchar(16) NOT NULL,
  `rec_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `description` varchar(128) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='学籍变更信息表';

-- ----------------------------
-- Records of change_info
-- ----------------------------
INSERT INTO `change_info` VALUES ('1', '13', '2', '2018-06-13 15:33:32', 'ssssss');
INSERT INTO `change_info` VALUES ('2', '12', '2', '2018-06-13 17:27:09', 'fzxz');

-- ----------------------------
-- Table structure for class_info
-- ----------------------------
DROP TABLE IF EXISTS `class_info`;
CREATE TABLE `class_info` (
  `id` varchar(8) NOT NULL,
  `name` varchar(32) NOT NULL,
  `monitor_id` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='班级信息表';

-- ----------------------------
-- Records of class_info
-- ----------------------------

-- ----------------------------
-- Table structure for department_info
-- ----------------------------
DROP TABLE IF EXISTS `department_info`;
CREATE TABLE `department_info` (
  `id` varchar(8) NOT NULL,
  `name` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='院系信息表';

-- ----------------------------
-- Records of department_info
-- ----------------------------

-- ----------------------------
-- Table structure for punishment_info
-- ----------------------------
DROP TABLE IF EXISTS `punishment_info`;
CREATE TABLE `punishment_info` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `student_id` varchar(32) NOT NULL,
  `levels` varchar(8) NOT NULL,
  `enable` varchar(4) NOT NULL,
  `description` varchar(128) NOT NULL,
  `rec_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='处罚记录信息表';

-- ----------------------------
-- Records of punishment_info
-- ----------------------------
INSERT INTO `punishment_info` VALUES ('1', '1', '2', '2', '3', '2018-06-21 12:14:26');
INSERT INTO `punishment_info` VALUES ('2', '2', '2', '2', '2', '2018-06-21 12:16:17');

-- ----------------------------
-- Table structure for punish_levels_info
-- ----------------------------
DROP TABLE IF EXISTS `punish_levels_info`;
CREATE TABLE `punish_levels_info` (
  `code` varchar(8) NOT NULL,
  `description` varchar(128) NOT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='处罚等级代码表';

-- ----------------------------
-- Records of punish_levels_info
-- ----------------------------
INSERT INTO `punish_levels_info` VALUES ('0', '警告');
INSERT INTO `punish_levels_info` VALUES ('1', '严重警告');
INSERT INTO `punish_levels_info` VALUES ('2', '记过');
INSERT INTO `punish_levels_info` VALUES ('3', '记大过');
INSERT INTO `punish_levels_info` VALUES ('4', '开除');

-- ----------------------------
-- Table structure for reward_info
-- ----------------------------
DROP TABLE IF EXISTS `reward_info`;
CREATE TABLE `reward_info` (
  `id` varchar(8) NOT NULL,
  `student_id` varchar(32) NOT NULL,
  `levels` varchar(8) NOT NULL,
  `description` varchar(128) NOT NULL,
  `rec_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='奖励记录表';

-- ----------------------------
-- Records of reward_info
-- ----------------------------
INSERT INTO `reward_info` VALUES ('1', '1', '2', '3', '2018-06-21 12:14:36');

-- ----------------------------
-- Table structure for reward_levels_info
-- ----------------------------
DROP TABLE IF EXISTS `reward_levels_info`;
CREATE TABLE `reward_levels_info` (
  `code` varchar(8) NOT NULL,
  `description` varchar(128) NOT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='奖励等级代码表';

-- ----------------------------
-- Records of reward_levels_info
-- ----------------------------
INSERT INTO `reward_levels_info` VALUES ('0', '校特等奖学金');
INSERT INTO `reward_levels_info` VALUES ('1', '校一等奖学金');
INSERT INTO `reward_levels_info` VALUES ('2', '校二等奖学金');
INSERT INTO `reward_levels_info` VALUES ('3', '校三等奖学金');
INSERT INTO `reward_levels_info` VALUES ('4', '系一等奖学金');
INSERT INTO `reward_levels_info` VALUES ('5', '系二等奖学金');
INSERT INTO `reward_levels_info` VALUES ('6', '系三等奖学金');

-- ----------------------------
-- Table structure for student_info
-- ----------------------------
DROP TABLE IF EXISTS `student_info`;
CREATE TABLE `student_info` (
  `student_id` varchar(32) NOT NULL,
  `name` varchar(32) NOT NULL,
  `sex` varchar(8) NOT NULL,
  `class` varchar(16) NOT NULL,
  `department` varchar(16) NOT NULL,
  `birthday` varchar(32) NOT NULL,
  `native_place` varchar(64) NOT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='学生信息表';

-- ----------------------------
-- Records of student_info
-- ----------------------------
INSERT INTO `student_info` VALUES ('1', 'Tom', '男', '12', '1', '1992.3', '湖南');
INSERT INTO `student_info` VALUES ('2', 'Tom', '男', '13', '4', '1992.2', '湖南');
INSERT INTO `student_info` VALUES ('3', 'Tomkh', '男', '12', '1', '1992.3', '湖南');
