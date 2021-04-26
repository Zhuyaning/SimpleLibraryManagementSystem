/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : localhost:3306
 Source Schema         : sqltest

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 26/04/2021 20:44:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `sn` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `author` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `price` decimal(10, 2) NULL DEFAULT NULL,
  `dirId` bigint(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (9, '025', 'Java从入门到精通', 'wolfcode8', 550.00, 1);
INSERT INTO `book` VALUES (12, '856', 'Java项目实战100天', '小码', 600.00, 1);
INSERT INTO `book` VALUES (14, '126', 'Java从入门到入土', '小崔', 123.00, 1);
INSERT INTO `book` VALUES (17, '007', 'UI1', '钟同学1', 888.00, 2);
INSERT INTO `book` VALUES (18, '009', '编程好', '小明', 600.00, 1);
INSERT INTO `book` VALUES (19, '008', '毛台', '小明', 100.00, 2);
INSERT INTO `book` VALUES (20, '101', 'H5', '冷檬', 123.00, 1);
INSERT INTO `book` VALUES (21, '002', 'Spring', 'sunny', 123.00, 2);
INSERT INTO `book` VALUES (22, '002', 'Spring', '小明', 123.00, 3);
INSERT INTO `book` VALUES (23, '002', 'Spring', '小明', 123.00, 2);
INSERT INTO `book` VALUES (24, '125', '一夜暴富', '222', 3333.00, 2);
INSERT INTO `book` VALUES (25, '006', 'Spring', '小狼', 123.00, 1);
INSERT INTO `book` VALUES (26, '006', 'Spring', '小狼', 123.00, 1);
INSERT INTO `book` VALUES (27, '123', '666', '222', 3333.00, 2);
INSERT INTO `book` VALUES (31, '888', '社会科学', 'SusuStardust', 50.00, 7);
INSERT INTO `book` VALUES (32, '451', 'unity3d', 'SusuStardust', 555.00, 1);
INSERT INTO `book` VALUES (33, '777', '桥梁建筑设计指导', 'SusuStardust', 8282.00, 5);
INSERT INTO `book` VALUES (34, '741', '航天技术导论', '七元', 57.00, 2);
INSERT INTO `book` VALUES (35, '856', '内燃机原理解析', 'james Tiber', 412.00, 2);
INSERT INTO `book` VALUES (36, '115', 'Java从入门到精通222', '小韩', 8282.00, 8);

-- ----------------------------
-- Table structure for directory
-- ----------------------------
DROP TABLE IF EXISTS `directory`;
CREATE TABLE `directory`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `describes` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of directory
-- ----------------------------
INSERT INTO `directory` VALUES (1, '计算机', '计算机技术');
INSERT INTO `directory` VALUES (2, '机械', '机械制造');
INSERT INTO `directory` VALUES (3, '电子', '电子信息技术');
INSERT INTO `directory` VALUES (5, '建筑', '工程建筑');
INSERT INTO `directory` VALUES (6, '文学', '品味文字优美');
INSERT INTO `directory` VALUES (7, '社会科学', '描述社会科学是怎样的科学');
INSERT INTO `directory` VALUES (8, '商务', '简述交易的艺术');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `uid` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户名',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户密码',
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'zhuyaning', '123456');
INSERT INTO `user` VALUES (3, '123456', '123456');
INSERT INTO `user` VALUES (4, '朱亚宁', '123456');
INSERT INTO `user` VALUES (6, 'zyn', '123456');
INSERT INTO `user` VALUES (7, '123', '123456');

SET FOREIGN_KEY_CHECKS = 1;
