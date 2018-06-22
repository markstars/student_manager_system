/*
Navicat MySQL Data Transfer

Source Server         : zhonggh
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : student_system

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-06-22 20:08:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `sno` varchar(20) NOT NULL,
  `department` varchar(20) DEFAULT NULL,
  `hometown` varchar(20) DEFAULT NULL,
  `sex` varchar(20) DEFAULT NULL,
  `specialty` varchar(20) DEFAULT NULL,
  `stuclass` varchar(20) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '李四', '17601310112', '电子信息工程学院', '广东', '男', '电子商务专业', '17电子商务1班', '14215321521');
INSERT INTO `student` VALUES ('2', '熬二', '12222222222', '外国语学院', '上海', '男', '英语专业', '15英语专业', '17978423557');
INSERT INTO `student` VALUES ('3', '王五', '17601310111', '电子信息工程学院', '广东', '男', '软件技术专业', '17软件技术9班', '14785214787');
INSERT INTO `student` VALUES ('4', '周六', '17601310888', '电子信息工程学院', '广东', '女', '软件技术', '17软件技术5班', '15643278954');
INSERT INTO `student` VALUES ('5', '辛七', '17601310555', '外国语学院', '上海', '女', '英语专业', '15英语专业', '17965423557');
INSERT INTO `student` VALUES ('6', '五邑', '17564231478', '金融管理学院', '南京', '男', '会计专业', '15会计9班', '15555555555');
INSERT INTO `student` VALUES ('7', '柩久', '19999999999', '金融管理学院', '北京', '女', '会计专业', '15会计9班', '1999999999');
INSERT INTO `student` VALUES ('8', '读史', '12578954655', '外国语学院', '上海', '男', '英语专业', '15英语专业5班', '17975323557');
INSERT INTO `student` VALUES ('9', '李四', '17601810112', '外国语学院', '上海', '男', '英语专业', '15英语专业4班', '17975323557');
INSERT INTO `student` VALUES ('10', '李四', '17601310988', '外国语学院', '上海', '男', '英语专业', '15英语专业3班', '17975323557');
INSERT INTO `student` VALUES ('11', '李四', '17601310982', '外国语学院', '上海', '男', '英语专业', '15英语专业2班', '17975323557');
INSERT INTO `student` VALUES ('12', '李四', '17601353988', '外国语学院', '上海', '男', '英语专业', '15英语专业5班', '17975323557');
INSERT INTO `student` VALUES ('13', '王五', '17601310788', '金融管理学院', '南京', '女', '会计专业', '15会计9班', '15555557539');
INSERT INTO `student` VALUES ('14', '王五', '14601310988', '金融管理学院', '南京', '女', '会计专业', '15会计9班', '15555578914');
INSERT INTO `student` VALUES ('15', '张三', '15601310988', '金融管理学院', '南京', '男', '会计专业', '15会计9班', '19855578914');
INSERT INTO `student` VALUES ('16', '张三', '16601310988', '电子信息工程学院', '长沙', '男', '电子商务专业', '17电子商务1班', '19215578914');
INSERT INTO `student` VALUES ('17', '吴起', '17601310724', '电子信息工程学院', '长沙', '男', '电子商务专业', '17电子商务1班', '19213478914');
INSERT INTO `student` VALUES ('18', '刘备', '17451310988', '金融管理学院', '北京', '女', '会计专业', '15会计9班', '19213475894');
INSERT INTO `student` VALUES ('19', '关羽', '17413610988', '社会学院', '长沙', '男', '打铁专业', '11打铁9班', '19213475894');
INSERT INTO `student` VALUES ('20', '张飞', '17601378245', '社会学院', '长沙', '女', '卖肉专业', '12卖肉7班', '19213475894');
