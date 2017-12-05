/*
Navicat MySQL Data Transfer

Source Server         : zll
Source Server Version : 50022
Source Host           : localhost:3306
Source Database       : chatroom

Target Server Type    : MYSQL
Target Server Version : 50022
File Encoding         : 65001

Date: 2014-06-30 12:48:11
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `msginfo`
-- ----------------------------
DROP TABLE IF EXISTS `msginfo`;
CREATE TABLE `msginfo` (
  `id` int(11) NOT NULL auto_increment,
  `chatroom` varchar(50) default NULL,
  `msgfrom` varchar(50) default NULL,
  `msgto` varchar(50) default NULL,
  `chattime` datetime default NULL,
  `chataction` varchar(50) default NULL,
  `msgcontent` varchar(200) default NULL,
  `secret` tinyint(1) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of msginfo
-- ----------------------------
INSERT INTO msginfo VALUES ('27', 'java学习讨论区', '系统公告', '所有人', '2014-06-28 10:08:38', '说：', '<font color=red>郑乐乐</font>进入了聊天室，大家欢迎！', '0');
INSERT INTO msginfo VALUES ('28', 'java学习讨论区', '系统公告', '所有人', '2014-06-28 10:10:16', '说：', '<font color=red>马旭山</font>进入了聊天室，大家欢迎！', '0');
INSERT INTO msginfo VALUES ('29', 'java学习讨论区', '郑乐乐', '马旭山', '2014-06-28 10:13:14', '说：', '<font color=FF0000>你好！</font>', '0');
INSERT INTO msginfo VALUES ('30', 'java学习讨论区', '马旭山', '马旭山', '2014-06-28 10:13:37', '说：', '<font color=#00CC00>你好！</font>', '0');
INSERT INTO msginfo VALUES ('31', 'java学习讨论区', '系统公告', '所有人', '2014-06-28 10:27:12', '说：', '<font color=red>admin</font>进入了聊天室，大家欢迎！', '0');
INSERT INTO msginfo VALUES ('32', 'java学习讨论区', '郑乐乐', '郑乐乐', '2014-06-28 10:45:51', '说：', '<font color=FF0000>1</font>', '0');
INSERT INTO msginfo VALUES ('33', 'java学习讨论区', '系统公告', '所有人', '2014-06-29 16:05:28', '说：', '<font color=red>admin</font>进入了聊天室，大家欢迎！', '0');
INSERT INTO msginfo VALUES ('34', '游戏讨论区', '系统公告', '所有人', '2014-06-30 12:43:54', '说：', '<font color=red>admin</font>进入了聊天室，大家欢迎！', '0');

-- ----------------------------
-- Table structure for `userinfo`
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `id` int(11) NOT NULL auto_increment,
  `username` varchar(50) default NULL,
  `pass` varchar(50) default NULL,
  `lastlogintime` datetime default NULL,
  `role` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO userinfo VALUES ('1', 'admin', '123', '2014-06-30 12:42:55', '1');
INSERT INTO userinfo VALUES ('25', '郑乐乐', '123', '2014-06-28 10:08:33', '0');
INSERT INTO userinfo VALUES ('26', '马旭山', '123', '2014-06-28 10:10:13', '0');
INSERT INTO userinfo VALUES ('27', 'zheng', '123', '2014-06-29 16:05:21', '0');

-- ----------------------------
-- Table structure for `useronline`
-- ----------------------------
DROP TABLE IF EXISTS `useronline`;
CREATE TABLE `useronline` (
  `id` int(11) NOT NULL auto_increment,
  `chatroom` varchar(50) default NULL,
  `username` varchar(50) default NULL,
  `lastchattime` datetime default NULL,
  `denyroom` varchar(50) default NULL,
  `denytime` datetime default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of useronline
-- ----------------------------
INSERT INTO useronline VALUES ('1', 'java学习讨论区', 'admin', null, null, null);
INSERT INTO useronline VALUES ('2', '游戏讨论区', 'admin', null, null, null);
