/*
Navicat MySQL Data Transfer

Source Server         : WJ
Source Server Version : 80016
Source Host           : localhost:3306
Source Database       : finemp

Target Server Type    : MYSQL
Target Server Version : 80016
File Encoding         : 65001

Date: 2021-03-01 17:41:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_arcticle`
-- ----------------------------
DROP TABLE IF EXISTS `t_arcticle`;
CREATE TABLE `t_arcticle` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `arcticleclass` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `tags` varchar(40) DEFAULT NULL,
  `title` varchar(60) DEFAULT NULL,
  `about` varchar(100) DEFAULT NULL,
  `imgpath` varchar(100) DEFAULT NULL,
  `content` mediumtext,
  `create_date` date DEFAULT NULL,
  `update_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_arcticle
-- ----------------------------
INSERT INTO `t_arcticle` VALUES ('1', 'Life', 'Life', '生活', '1', '75956507-2e9e-4c4e-b533-fda80746d2c2.jpg', '<p>加班加班加班加班加班</p><p><img src=\"http://localhost:8888/yanger/file/getImg?path=/ueditor/img/20200717/1594978333762068549.jpg\" title=\"1594978333762068549.jpg\" alt=\"img.jpg\"/></p>', '2021-02-24', '2021-02-24');
INSERT INTO `t_arcticle` VALUES ('2', 'Code', 'Java', '标题Java', '2', '75956507-2e9e-4c4e-b533-fda80746d2c2.jpg', '<p>加班加班加班加班加班</p><p><img src=\"http://localhost:8888/yanger/file/getImg?path=/ueditor/img/20200717/1594978333762068549.jpg\" title=\"1594978333762068549.jpg\" alt=\"img.jpg\"/></p>', '2021-03-01', '2021-03-01');
INSERT INTO `t_arcticle` VALUES ('3', 'Code', 'Linux', 'Linux入门', '3', '75956507-2e9e-4c4e-b533-fda80746d2c2.jpg', '<p>加班加班加班加班加班</p><p><img src=\"http://localhost:8888/yanger/file/getImg?path=/ueditor/img/20200717/1594978333762068549.jpg\" title=\"1594978333762068549.jpg\" alt=\"img.jpg\"/></p>', '2021-03-01', '2021-03-01');
INSERT INTO `t_arcticle` VALUES ('4', 'Code', 'Linux', '精通', '4', '75956507-2e9e-4c4e-b533-fda80746d2c2.jpg', '<p>加班加班加班加班加班</p><p><img src=\"http://localhost:8888/yanger/file/getImg?path=/ueditor/img/20200717/1594978333762068549.jpg\" title=\"1594978333762068549.jpg\" alt=\"img.jpg\"/></p>', '2021-03-01', '2021-03-01');
INSERT INTO `t_arcticle` VALUES ('5', null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `t_emp`
-- ----------------------------
DROP TABLE IF EXISTS `t_emp`;
CREATE TABLE `t_emp` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) NOT NULL,
  `type` varchar(20) NOT NULL,
  `computer` varchar(40) NOT NULL,
  `mouse` varchar(40) NOT NULL,
  `other` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_emp
-- ----------------------------
INSERT INTO `t_emp` VALUES ('1', '李同灵', '笔记本', '惠普', '小米无线鼠标', '显卡');
INSERT INTO `t_emp` VALUES ('2', '张发舜', '台式', '戴尔', '小米无线鼠标', '内存条:8G+显卡2G');
INSERT INTO `t_emp` VALUES ('5', '陈智力', '笔记本', '惠普', '有线鼠标', '风扇');
INSERT INTO `t_emp` VALUES ('6', '严世强', '笔记本', '惠普', '戴尔', '无');
INSERT INTO `t_emp` VALUES ('8', '钱育叶', '笔记本', '惠普', '无线', '有线');
INSERT INTO `t_emp` VALUES ('9', '梁燕', '笔记本', '惠普', '无线鼠标', '有线电视');
INSERT INTO `t_emp` VALUES ('10', '吕学学', '笔记本', '戴尔', '小米无线鼠标', '宏碁电脑');
INSERT INTO `t_emp` VALUES ('11', '周锋', '笔记本', '惠普', '鼠标', '无');
INSERT INTO `t_emp` VALUES ('12', '吴宇宁', '台式', '戴尔', '有线鼠标', '都放到');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `roles` varchar(50) NOT NULL,
  `regstertime` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `realname` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'admin', '123', 'admin', '2020-08-30 12:22:59', 'admin');
INSERT INTO `t_user` VALUES ('2', 'li', '123', 'visitor', '2020-08-30 12:24:46', 'Lee');
INSERT INTO `t_user` VALUES ('3', 'tt', '1234', 'visitor', '2020-08-30 06:50:26', '李同灵');
