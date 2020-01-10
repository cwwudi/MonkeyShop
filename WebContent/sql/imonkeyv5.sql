/*
 Navicat MySQL Data Transfer

 Source Server         : 本地数据库
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : imonkey

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 10/01/2020 17:04:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for imonkey_category
-- ----------------------------
DROP TABLE IF EXISTS `imonkey_category`;
CREATE TABLE `imonkey_category`  (
  `CATE_ID` int(10) NOT NULL AUTO_INCREMENT,
  `CATE_NAME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `CATE_PARENT_ID` decimal(10, 0) NOT NULL,
  PRIMARY KEY (`CATE_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of imonkey_category
-- ----------------------------
INSERT INTO `imonkey_category` VALUES (1, 'JAVA图书', 0);
INSERT INTO `imonkey_category` VALUES (2, 'C#图书', 0);
INSERT INTO `imonkey_category` VALUES (3, 'Linux图书', 0);
INSERT INTO `imonkey_category` VALUES (4, 'Java se图书', 1);
INSERT INTO `imonkey_category` VALUES (5, 'Java EE图书', 1);
INSERT INTO `imonkey_category` VALUES (6, 'C#基础', 2);
INSERT INTO `imonkey_category` VALUES (8, 'Linux系统', 3);
INSERT INTO `imonkey_category` VALUES (9, 'PHP图书', 0);
INSERT INTO `imonkey_category` VALUES (10, 'Python图书', 0);
INSERT INTO `imonkey_category` VALUES (11, 'Java 框架', 1);
INSERT INTO `imonkey_category` VALUES (12, 'C#进阶', 2);
INSERT INTO `imonkey_category` VALUES (13, 'PHP基础', 9);
INSERT INTO `imonkey_category` VALUES (14, 'PHP高级', 9);
INSERT INTO `imonkey_category` VALUES (15, 'Python 人工智能', 10);
INSERT INTO `imonkey_category` VALUES (16, 'Python 爬虫', 10);
INSERT INTO `imonkey_category` VALUES (17, 'Linux运维', 3);
INSERT INTO `imonkey_category` VALUES (18, 'linux 网络', 3);

-- ----------------------------
-- Table structure for imonkey_product
-- ----------------------------
DROP TABLE IF EXISTS `imonkey_product`;
CREATE TABLE `imonkey_product`  (
  `PRODUCT_ID` int(10) NOT NULL AUTO_INCREMENT,
  `PRODUCT_NAME` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `PRODUCT_DESCRIPTION` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `PRODUCT_PRICE` decimal(10, 2) NOT NULL,
  `PRODUCT_STOCK` decimal(10, 0) NULL DEFAULT NULL,
  `PRODUCT_FCATE` decimal(10, 0) NULL DEFAULT NULL,
  `PRODUCT_CCATE` decimal(10, 0) NULL DEFAULT NULL,
  `PRODUCT_FILENAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`PRODUCT_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of imonkey_product
-- ----------------------------
INSERT INTO `imonkey_product` VALUES (1, 'fhhhh', 'ghr', 12.50, 20, 1, 4, 'fsdfs');

-- ----------------------------
-- Table structure for imonkey_user
-- ----------------------------
DROP TABLE IF EXISTS `imonkey_user`;
CREATE TABLE `imonkey_user`  (
  `USER_ID` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `USER_NAME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `USER_PASSWORD` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `USER_SEX` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `USER_BIRHFDAY` datetime(0) NOT NULL,
  `USER_IDENITY_CODE` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `USER_EAMIL` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `USER_MOBILE` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `USER_ADDRESS` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `USER_STATUES` decimal(6, 0) NOT NULL,
  PRIMARY KEY (`USER_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of imonkey_user
-- ----------------------------
INSERT INTO `imonkey_user` VALUES ('231231', '23231', '2312312', 'T', '1990-09-11 00:00:00', NULL, '11123123123123123', '23123', '44123123', 2);
INSERT INTO `imonkey_user` VALUES ('caow', 'admin', 'cw900515', 'T', '1990-05-15 00:00:00', NULL, 'songkunlin@yanda.com.cn111', '13862862411', 'sjaodhadsdn', 2);
INSERT INTO `imonkey_user` VALUES ('caowei111', 'ccc', 'aaa', 'T', '2020-01-01 00:00:00', NULL, 'sdad@qqddsd', 'sd123123', '1231231', 1);
INSERT INTO `imonkey_user` VALUES ('sdasdasd', 'sdada', '11', 'T', '2020-01-16 00:00:00', NULL, '1112312312@daca', 'sd123123', 'sdadasdasdasd', 1);
INSERT INTO `imonkey_user` VALUES ('zhaow', 'admin1', 'cw900515', 'T', '1990-05-15 00:00:00', NULL, 'songkunlin@yanda.com.cn', '13862862411', 'sjaodhadsdn', 2);
INSERT INTO `imonkey_user` VALUES ('zhaowwww27', 'admin1', 'cw900515', 'F', '1990-05-15 00:00:00', NULL, 'songkunlin@yanda.com.cn', '13862862411', 'sjaodhadsdn', 1);
INSERT INTO `imonkey_user` VALUES ('zhaowwww29', 'admin1', 'cw900515', 'F', '1990-05-15 00:00:00', NULL, 'songkunlin@yanda.com.cn', '13862862411', 'sjaodhadsdn', 1);
INSERT INTO `imonkey_user` VALUES ('zhaowwww30', 'admin12222111', 'cw900515', 'F', '1990-05-15 00:00:00', NULL, 'songkunlin@yanda.com.cn', '13862862411', 'sjaodhadsdn', 1);

SET FOREIGN_KEY_CHECKS = 1;
